package jae.phones.JAEphones.Controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jae.phones.JAEphones.Exception.AppException;
import jae.phones.JAEphones.Model.Role;
import jae.phones.JAEphones.Model.RoleName;
import jae.phones.JAEphones.Model.User;
import jae.phones.JAEphones.Payloads.ApiResponse;
import jae.phones.JAEphones.Payloads.JwtAuthenticationResponse;
import jae.phones.JAEphones.Payloads.LoginRequest;
import jae.phones.JAEphones.Payloads.SingUpRequest;
import jae.phones.JAEphones.Repository.RoleRepository;
import jae.phones.JAEphones.Repository.UserRepository;
import jae.phones.JAEphones.Security.JwtTokenProvider;

/**
 * AuthController
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtTokenProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest login) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getUsernameOrEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = this.jwtProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SingUpRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username already exists"), HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email already exists"), HttpStatus.BAD_REQUEST);
        }
        User user = new User(signupRequest.getName(), signupRequest.getUsername(), signupRequest.getEmail(),
                signupRequest.getPassword());
        user.setPassword(encoder.encode(user.getPassword()));

        Role role = roleRepository.findByRole(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User role not set"));
        user.setRoles(Collections.singleton(role));
        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User register successfully"));
    }
}
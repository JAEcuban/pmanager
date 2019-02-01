package jae.phones.JAEphones.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jae.phones.JAEphones.Exception.ResourceNotFoundException;
import jae.phones.JAEphones.Model.User;
import jae.phones.JAEphones.Repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    @Secured("ROLE_ADMIN")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    public User findById(@PathVariable(value = "id") Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
}
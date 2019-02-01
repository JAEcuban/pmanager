package jae.phones.JAEphones.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jae.phones.JAEphones.Model.Role;
import jae.phones.JAEphones.Repository.RoleRepository;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/role")
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @PostMapping("role/new")
    public Role add(@Valid @RequestBody Role role) {
        return roleRepository.save(role);
    }
}
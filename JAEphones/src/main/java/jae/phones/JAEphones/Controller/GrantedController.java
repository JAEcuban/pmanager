package jae.phones.JAEphones.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jae.phones.JAEphones.Repository.GrantedRepository;

import jae.phones.JAEphones.Model.Granted;

@RestController
@RequestMapping("/api")
public class GrantedController {

    @Autowired
    private GrantedRepository grantedRepository;

    @GetMapping("/granted")
    public List<Granted> findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<Granted> grantees = grantedRepository.findAll(PageRequest.of(page, size, Sort.by(Direction.DESC, "id")));

        return grantees.getContent();
    }
}

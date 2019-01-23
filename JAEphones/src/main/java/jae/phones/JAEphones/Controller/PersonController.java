package jae.phones.JAEphones.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jae.phones.JAEphones.Model.Person;
import jae.phones.JAEphones.Repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("person/list")
    public List<Person> findAll() {
        Iterator<Person> iterator = personRepository.findAll().iterator();
        List<Person> persons = new ArrayList<Person>();
        while (iterator.hasNext()) {
            persons.add(iterator.next());
        }

        return persons;
    }

    @PostMapping("person/new")
    public Person addPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
}
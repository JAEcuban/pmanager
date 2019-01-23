package jae.phones.JAEphones.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jae.phones.JAEphones.Exception.ResourceNotFoundException;
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

    @GetMapping("person/{id}")
    public Person getById(@PathVariable(value = "id") Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
    }

    @PostMapping("person/new")
    public Person add(@Valid @RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("person/update/{id}")
    public Person update(@PathVariable(value = "id") Long id, @Valid @RequestBody Person person) {
        Person bdPerson = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
        bdPerson.setDni(person.getDni());
        bdPerson.setName(person.getName());

        return personRepository.save(bdPerson);
    }

    @DeleteMapping("person/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
        personRepository.delete(person);

        return ResponseEntity.ok().build();
    }
}
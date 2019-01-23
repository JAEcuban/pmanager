package jae.phones.JAEphones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jae.phones.JAEphones.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
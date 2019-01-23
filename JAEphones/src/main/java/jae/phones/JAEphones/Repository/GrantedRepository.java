package jae.phones.JAEphones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jae.phones.JAEphones.Model.Granted;

@Repository
public interface GrantedRepository extends JpaRepository<Granted, Long> {

}
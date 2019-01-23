package jae.phones.JAEphones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jae.phones.JAEphones.Model.Sim;

@Repository
public interface SimRepository extends JpaRepository<Sim, Long> {

}
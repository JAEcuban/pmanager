package jae.phones.JAEphones.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jae.phones.JAEphones.Model.Role;
import jae.phones.JAEphones.Model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Optional<Role> findByRole(RoleName role);
}
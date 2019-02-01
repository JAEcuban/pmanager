package jae.phones.JAEphones.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jae.phones.JAEphones.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);

    public Optional<User> findByUsernameOrEmail(String username, String email);

    public List<User> findByIdIn(List<Long> userIds);

    public Optional<User> findByUsername(String username);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);
}
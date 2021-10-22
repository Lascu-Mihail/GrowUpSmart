package ro.sda.echipa2.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.echipa2.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

    Optional<User> findByNameIgnoreCase(String name);
}

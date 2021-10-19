package ro.sda.echipa2.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.echipa2.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}

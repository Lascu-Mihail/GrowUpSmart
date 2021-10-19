package ro.sda.echipa2.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.echipa2.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAll();

    Optional<Task> findByNameIgnoreCase(String name);
}

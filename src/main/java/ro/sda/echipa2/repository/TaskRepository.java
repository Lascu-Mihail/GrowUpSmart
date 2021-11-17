package ro.sda.echipa2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sda.echipa2.model.Task;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAll();

    Optional<Task> findByNameIgnoreCase(String name);

    Optional<Task> deleteTaskByEndDate(Long id);
}

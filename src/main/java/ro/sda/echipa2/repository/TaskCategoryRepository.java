package ro.sda.echipa2.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.echipa2.model.TaskCategory;

import java.util.List;
import java.util.Optional;

public interface TaskCategoryRepository extends CrudRepository<TaskCategory, Long> {
    List<TaskCategory> findAll();

    Optional<TaskCategory> findByNameIgnoreCase(String name);
}

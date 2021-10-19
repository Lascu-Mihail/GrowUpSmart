package ro.sda.echipa2.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.echipa2.model.TaskCategory;

public interface TaskCategoryRepository extends CrudRepository<TaskCategory, Long> {

}

package ro.sda.echipa2.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.echipa2.model.UserCategory;

public interface UserCategoryRepository extends CrudRepository<UserCategory, Long> {
}

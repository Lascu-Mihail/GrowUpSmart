package ro.sda.echipa2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sda.echipa2.model.UserCategory;

@Repository
public interface UserCategoryRepository extends CrudRepository<UserCategory, Long> {
}

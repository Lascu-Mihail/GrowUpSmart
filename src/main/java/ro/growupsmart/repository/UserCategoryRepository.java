package ro.growupsmart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.growupsmart.model.UserCategory;

@Repository
public interface UserCategoryRepository extends CrudRepository<UserCategory, Long> {
}

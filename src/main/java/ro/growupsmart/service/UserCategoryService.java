package ro.growupsmart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.growupsmart.repository.UserCategoryRepository;
import ro.growupsmart.model.UserCategory;

@Service
public class UserCategoryService {
    private static final Logger log = LoggerFactory.getLogger(UserCategoryService.class);

    private final UserCategoryRepository userCategoryRepository;

    public UserCategoryService(UserCategoryRepository userCategoryRepository) {
        this.userCategoryRepository = userCategoryRepository;
    }

    public void save(UserCategory newCategory){
        log.info("saving category");
        userCategoryRepository.save(newCategory);
    }
}

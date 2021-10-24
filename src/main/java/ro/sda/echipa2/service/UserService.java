package ro.sda.echipa2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.echipa2.dto.UserUpdate;
import ro.sda.echipa2.exceptions.UserAlreadyExistsException;
import ro.sda.echipa2.model.User;
import ro.sda.echipa2.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User newUser) {
        log.info("Saving user");
        userRepository.save(newUser);
    }

    public List<User> findAll() {
        log.info("finding all users");
        return userRepository.findAll();
    }

    public User findById(Long id) {
        log.info("Finding by id");
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    public void updateUser(Long userId, UserUpdate userData) {
        log.info("update user {}", userData);

        userRepository.findById(userId)
                .map(existingUser -> updateEntity(userData, existingUser))
                .map(updatedUser -> userRepository.save(updatedUser))
                .orElseThrow(() -> new RuntimeException("user not found"));
    }

    public User updateEntity(UserUpdate userData, User existingUser) {
        existingUser.setEmail(userData.getEmail());
        existingUser.setPassword(userData.getPassword());
        return existingUser;
    }

    public void updateNewUser(User user) {
        log.info("update user {}", user);

        String email = user.getEmail();
        userRepository.findUserByEmail(email).filter(existingUser -> existingUser.getId().equals(user.getId()))
                .map(existingUser -> userRepository.save(user))
                .orElseThrow(() -> {
                    log.error("user with email {} already exists", email);
                    throw new UserAlreadyExistsException("user with name " + email + " already exists");

                });
    }
    @Transactional
    public void deleteUser(Long id) {
        log.info("deleting user by id");
        userRepository.deleteById(id);
    }
}

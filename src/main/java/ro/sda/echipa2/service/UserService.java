package ro.sda.echipa2.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.echipa2.config.token.ConfirmationToken;
import ro.sda.echipa2.dto.UserUpdate;
import ro.sda.echipa2.exceptions.UserAlreadyExistsException;
import ro.sda.echipa2.model.User;
import ro.sda.echipa2.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final String USER_NOT_FOUND_MSG="user with email %s not found";
    @Autowired
    private UserRepository userRepository;


    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

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
                .map(userRepository::save)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }

    public User updateEntity(UserUpdate userData, User existingUser) {
        existingUser.setEmail(userData.getEmail());
        existingUser.setPassword(userData.getPassword());
        return existingUser;
    }


    @Transactional
    public void deleteUser(Long id) {
        log.info("deleting user by id");
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findUserByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }

    public String signUpUser(User user){
        String email = user.getEmail();
        boolean userExist = userRepository.findUserByEmail(user.getEmail()).isPresent();
        if(userExist){
            throw new UserAlreadyExistsException("user with name"  + email + " already exists");
        }
        String encodedPassword = bCryptPasswordEncoder.
                encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
}

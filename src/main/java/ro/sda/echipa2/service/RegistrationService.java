package ro.sda.echipa2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.echipa2.config.token.ConfirmationToken;
import ro.sda.echipa2.enums.UserRole;
import ro.sda.echipa2.model.User;
import ro.sda.echipa2.registration.EmailValidator;
import ro.sda.echipa2.registration.RegistrationRequest;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private ConfirmationTokenService confirmationTokenService;


    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return userService.signUpUser(
                new User(request.getFirstName(),
                        request.getFirstName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER));

    }


}




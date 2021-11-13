package ro.sda.echipa2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.echipa2.enums.UserRole;
import ro.sda.echipa2.model.User;
import ro.sda.echipa2.registration.EmailValidator;
import ro.sda.echipa2.registration.RegistrationRequest;

@Service
@AllArgsConstructor
public class RegistrationService {

    private  UserService userService;
    private  EmailValidator emailValidator;

    public void register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
         userService.createUser(
                new User(request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER));

    }
}




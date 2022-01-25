package ro.sda.echipa2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.echipa2.config.token.ConfirmationToken;
import ro.sda.echipa2.enums.UserRole;
import ro.sda.echipa2.model.User;
import ro.sda.echipa2.registration.EmailSender;
import ro.sda.echipa2.registration.EmailValidator;
import ro.sda.echipa2.registration.RegistrationRequest;
import ro.sda.echipa2.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ConfirmationService {

    private final UserService userService;
    private ConfirmationTokenService confirmationTokenService;


    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(confirmationToken.getUser().getEmail());
        return "confirmed";
    }

}




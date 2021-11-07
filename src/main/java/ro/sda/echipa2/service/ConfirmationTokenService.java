package ro.sda.echipa2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.echipa2.config.token.ConfirmationToken;
import ro.sda.echipa2.repository.ConfirmationTokenRepository;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }



}

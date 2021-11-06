package ro.sda.echipa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.echipa2.config.token.ConfirmationToken;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken,Long> {


    Optional<ConfirmationToken> findByToken(String token);
}

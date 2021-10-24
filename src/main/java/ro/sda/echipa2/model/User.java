package ro.sda.echipa2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.sda.echipa2.enums.UserRole;
import javax.persistence.*;
import javax.validation.constraints.Email;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public User(String firstName, String lastName, String email, String password, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }
}


















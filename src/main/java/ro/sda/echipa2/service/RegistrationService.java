//package ro.sda.echipa2.service;
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import ro.sda.echipa2.model.AppUserRole;
//import ro.sda.echipa2.model.User;
//import ro.sda.echipa2.registration.EmailValidator;
//import ro.sda.echipa2.registration.RegistrationRequest;
//@Service
//@AllArgsConstructor
//public class RegistrationService {
//
//    private final UserService userService;
//    private final EmailValidator emailValidator;
//
////    public String register(RegistrationRequest request) {
////        boolean isValidEmail = emailValidator.test(request.getEmail());
////        if (!isValidEmail) {
////            throw new IllegalStateException("email not valid");
////        }
////
//////        return userService.singUpUser(
//////                new User(request.getFirstName(),
//////                        request.getLastName(),request.getEmail(),request.getPassword(),
//////                        AppUserRole.USER)
//////        );
//////    }
////    }
//}

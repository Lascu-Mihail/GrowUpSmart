package ro.sda.echipa2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.echipa2.model.User;
import ro.sda.echipa2.repository.UserRepository;
import ro.sda.echipa2.service.UserService;

import javax.validation.Valid;


@Controller
public class RegistrationController {

    private UserService userService;
    private UserRepository userRepository;

    public RegistrationController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @GetMapping("/registration")
    public String registration(Model model) { // !!!!!!!!!
        model.addAttribute("user", new User());
        return "registration";
    }
    @PostMapping("signUpUser")
    public String createUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signUpUser";
        }
        userService.signUpUser(user);
        return "redirect:/";
    }
}

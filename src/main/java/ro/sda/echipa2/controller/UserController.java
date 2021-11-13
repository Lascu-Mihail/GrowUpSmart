package ro.sda.echipa2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.echipa2.model.User;
import ro.sda.echipa2.repository.UserRepository;
import ro.sda.echipa2.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private UserRepository userRepository;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/users")
    public String showUsersPage(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("usersInView", users);
        return "index";
    }

}

package ro.sda.echipa2.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.echipa2.model.User;
import ro.sda.echipa2.service.UserService;
import java.util.List;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }
    @GetMapping("/users")
    public String showUsersPage(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("usersInView", users);
        return "index";
    }
    @GetMapping("/users/add")
    public String showAddUser(Model model){
        User newUser = new User();
        model.addAttribute("user",newUser);
        return "user-add";
    }

}

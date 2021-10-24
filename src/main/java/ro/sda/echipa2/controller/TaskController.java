package ro.sda.echipa2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.echipa2.service.TaskService;


@Slf4j
@Controller
public class TaskController {

    @Autowired
    TaskService taskService;
    @GetMapping("/tasks")
    public String showTasks(Model model){
        model.addAttribute("tasks", taskService.findAll());
        return "tasks";
    }

}

package ro.sda.echipa2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.echipa2.model.Task;
import ro.sda.echipa2.service.TaskService;


@Slf4j
@Controller
public class TaskController {


   private final TaskService taskService;

   @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String showTasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasks";
    }


    @GetMapping("/tasks/add")
    public String showAddFrom(Model model) {
        Task newTask= new Task();
        model.addAttribute("taskForm", newTask);
        return "addtask";
    }

    @PostMapping("/tasks/add")
    public String add(@ModelAttribute("taskForm") Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit")
    public String showEditForm(Model model) {
       model.addAttribute("tasks", taskService.findAll());
        return "edit-task";
    }

    @PostMapping("/task/edit")
    public String edit(@ModelAttribute("taskForm") Task task) {
     taskService.updateNewTask(task);
     return "redirect:/tasks";
    }
}
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
    public String add(@ModelAttribute("tasks") Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/edit")
    public String showEditForm(@PathVariable Long id ,Model model) {
       model.addAttribute("taskForm", taskService.findById(id));
        return "addtask";
    }

    @PostMapping("/tasks/{id}/edit")
    public String edit(@PathVariable Long id ,@ModelAttribute Task task) {
     taskService.updateNewTask(task);
     return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/delete")
    public String delete(@PathVariable long id){
       taskService.deleteTask(id);
       return "redirect:/tasks";
    }

    @GetMapping("/tasks/accept/{id}")
    public String acceptTask(@PathVariable("id") long taskId, Model model){
       //TODO implement accept task logic
       Task acceptedTask  = taskService.findById(taskId);
       log.info("Accepted task " +  acceptedTask);
        return "redirect:/tasks";
    }


}
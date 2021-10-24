package ro.sda.echipa2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sda.echipa2.model.Task;
import ro.sda.echipa2.model.TaskCategory;
import ro.sda.echipa2.service.TaskCategoryService;
import ro.sda.echipa2.service.TaskService;
import ro.sda.echipa2.service.UserService;

@Configuration
public class DbInit {


    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskCategoryService taskCategoryService;


//    @Bean
//    public CommandLineRunner initialData() {
//        return args -> {
//            TaskCategory laundry = new TaskCategory("Laundry","Washing all laundries");
//            taskCategoryService.save(laundry);
//
//            Task task1 = new Task("Do laundry", "Washing", laundry);
//            taskService.save(task1);
//
//        };
//
//    }
}


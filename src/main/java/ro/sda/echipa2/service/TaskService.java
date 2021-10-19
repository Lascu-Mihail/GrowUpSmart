package ro.sda.echipa2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ro.sda.echipa2.model.Task;
import ro.sda.echipa2.repository.TaskRepository;

import java.util.List;

public class TaskService {
    private static final Logger log = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(Task newTask) {
        log.info("saving task");
        taskRepository.save(newTask);
    }

    public List<Task> findAll(){
        log.info("Finding all tasks");
        return taskRepository.findAll();
    }

}

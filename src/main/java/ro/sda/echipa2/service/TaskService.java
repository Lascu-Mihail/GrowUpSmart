package ro.sda.echipa2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.echipa2.dto.TaskUpdate;
import ro.sda.echipa2.exceptions.TaskAlreadyExistsException;
import ro.sda.echipa2.model.Task;
import ro.sda.echipa2.repository.TaskRepository;

import java.util.List;

@Service
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

    public List<Task> findAll() {
        log.info("Finding all tasks");
        return taskRepository.findAll();
    }

    public Task updateEntity(TaskUpdate taskData, Task existingTask) {
        existingTask.setName(taskData.getName());
        existingTask.setDescription(taskData.getDescription());
        return existingTask;
    }

    public void updateTask(Long taskId, TaskUpdate taskData) {
        log.info("update task {}", taskData);

        taskRepository.findById(taskId)
                .map(existingTask -> updateEntity(taskData, existingTask))
                .map(updateTask -> taskRepository.save(updateTask))
                .orElseThrow(() -> new RuntimeException("task not found"));
    }

    public void updateNewTask(Task task){
        log.info("update task {}",task);

        String name = task.getName();

        taskRepository.findByNameIgnoreCase(name).filter(existingTask ->existingTask.getId().equals(task.getId()))
                .map(existingTask -> taskRepository.save(task))
                .orElseThrow(() -> {
                   log.error("task with name {} already exists",name);
                   throw new TaskAlreadyExistsException("task with name " + name + " already exists");
                });
    }

    @Transactional
    public void deleteTask(Long id){
        log.info("deleting task by id");
        taskRepository.deleteById(id);
    }

}

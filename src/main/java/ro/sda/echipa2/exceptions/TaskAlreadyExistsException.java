package ro.sda.echipa2.exceptions;

public class TaskAlreadyExistsException extends RuntimeException{
    public TaskAlreadyExistsException(String message){
        super("Task already exists!");
    }
}

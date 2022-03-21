package ro.growupsmart.exceptions;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException() {
        super("Value is invalid");
    }
}

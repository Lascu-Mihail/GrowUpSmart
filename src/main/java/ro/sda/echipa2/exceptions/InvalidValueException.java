package ro.sda.echipa2.exceptions;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException() {
        super("Value is invalid");
    }
}

package ro.sda.echipa2.exceptions;

public class CategoryAlreadyExists extends RuntimeException{
    public CategoryAlreadyExists(String message){
        super("Category already exists!");
    }
}

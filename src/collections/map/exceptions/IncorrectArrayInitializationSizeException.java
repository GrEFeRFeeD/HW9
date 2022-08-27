package collections.map.exceptions;

public class IncorrectArrayInitializationSizeException extends Exception{
    public IncorrectArrayInitializationSizeException() {
        super("Change initialization capacity for array to value bigger than 0");
    }
}

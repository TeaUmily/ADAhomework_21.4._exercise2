package hr.ferit.tumiljanovic.simplecalculator;

public class InvalidInputException extends Exception {

    private String msg= "Invalid input!";

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String msg) {
        super(msg);
    }
}



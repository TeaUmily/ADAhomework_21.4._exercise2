package hr.ferit.tumiljanovic.simplecalculator;

public class EmptyFieldException extends InvalidInputException {

    public EmptyFieldException() {
    }

    public EmptyFieldException(String msg) {
        super(msg);
    }
}

package hr.ferit.tumiljanovic.simplecalculator;

class DivideByZeroException extends InvalidInputException {

    public DivideByZeroException() {
    }

    public DivideByZeroException(String msg) {
        super(msg);
    }
}

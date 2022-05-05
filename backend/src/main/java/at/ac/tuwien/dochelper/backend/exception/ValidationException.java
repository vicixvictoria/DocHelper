package at.ac.tuwien.dochelper.backend.exception;

public class ValidationException extends RuntimeException{

    public ValidationException () { }
    public ValidationException (String message) { super(message); }
    public ValidationException (Exception e) { super (e); }
}

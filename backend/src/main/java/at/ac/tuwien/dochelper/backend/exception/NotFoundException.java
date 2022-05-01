package at.ac.tuwien.dochelper.backend.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException () { }
    public NotFoundException (String message) { super(message); }
    public NotFoundException (Exception e) { super (e); }
}

package ro.project.fiipractic.Bitter.exception;

public class NotLoggedInException extends RuntimeException {
    public NotLoggedInException(String message)
    {
        super(message);
    }
}

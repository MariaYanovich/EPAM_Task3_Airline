package by.training.task3.airline.exception;


public class CreatorOfPlaneException extends Exception {
    public CreatorOfPlaneException() {
    }

    public CreatorOfPlaneException(String message) {
        super(message);
    }

    public CreatorOfPlaneException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatorOfPlaneException(Throwable cause) {
        super(cause);
    }

    public CreatorOfPlaneException(String message, Throwable cause,
                                   boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package by.training.task3.airline.exception;


public class AirlineRepositoryException extends Exception {
    public AirlineRepositoryException() {
    }

    public AirlineRepositoryException(String message) {
        super(message);
    }

    public AirlineRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public AirlineRepositoryException(Throwable cause) {
        super(cause);
    }

    public AirlineRepositoryException(String message, Throwable cause,
                                      boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package by.training.task3.airline.exception;

import java.io.IOException;

public class AirlineRepositoryException extends IOException {
    public AirlineRepositoryException() {
    }

    public AirlineRepositoryException(Throwable cause) {
        super(cause);
    }

    public AirlineRepositoryException(String message) {
        super(message);
    }

    public AirlineRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}

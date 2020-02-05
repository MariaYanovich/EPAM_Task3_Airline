package by.training.task3.airline.exception;

import java.io.IOException;

public class PlaneRepositoryException extends IOException {
    public PlaneRepositoryException() {
    }

    public PlaneRepositoryException(Throwable cause) {
        super(cause);
    }

    public PlaneRepositoryException(String message) {
        super(message);
    }

    public PlaneRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}

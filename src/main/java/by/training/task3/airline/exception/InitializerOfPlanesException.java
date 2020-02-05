package by.training.task3.airline.exception;

import java.io.IOException;

public class InitializerOfPlanesException extends IOException {
    public InitializerOfPlanesException() {
    }

    public InitializerOfPlanesException(Throwable cause) {
        super(cause);
    }

    public InitializerOfPlanesException(String message) {
        super(message);
    }

    public InitializerOfPlanesException(String message, Throwable cause) {
        super(message, cause);
    }
}

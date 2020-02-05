package by.training.task3.airline.exception;

import java.io.IOException;

public class ReaderOfPlanesFromTxtFileException extends IOException {
    public ReaderOfPlanesFromTxtFileException() {
    }

    public ReaderOfPlanesFromTxtFileException(Throwable cause) {
        super(cause);
    }

    public ReaderOfPlanesFromTxtFileException(String message) {
        super(message);
    }

    public ReaderOfPlanesFromTxtFileException(String message, Throwable cause) {
        super(message, cause);
    }
}

package by.training.task3.airline.exception;


public class ReaderOfPlanesFromTxtFileException extends Exception {
    public ReaderOfPlanesFromTxtFileException() {
    }

    public ReaderOfPlanesFromTxtFileException(String message) {
        super(message);
    }

    public ReaderOfPlanesFromTxtFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReaderOfPlanesFromTxtFileException(Throwable cause) {
        super(cause);
    }

    public ReaderOfPlanesFromTxtFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

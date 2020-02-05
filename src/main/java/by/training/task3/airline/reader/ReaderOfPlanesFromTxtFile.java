package by.training.task3.airline.reader;

import by.training.task3.airline.exception.ReaderOfPlanesFromTxtFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class ReaderOfPlanesFromTxtFile {
    private static Logger LOGGER = LogManager.getLogger(ReaderOfPlanesFromTxtFile.class.getName());
    private ArrayList<String> arrayListOfPlanesParameters;
    private String filename;

    public ReaderOfPlanesFromTxtFile() {
        this.arrayListOfPlanesParameters = new ArrayList<>();
        this.filename = ".\\src\\main\\resources\\Planes.txt";
        try {
            setArrayListOfPlanesParameters(readFromTxtFile());
        } catch (ReaderOfPlanesFromTxtFileException e) {
            LOGGER.error("File is empty. Repository will be empty at start.");
        }
    }

    public ArrayList<String> getArrayListOfPlanesParameters() {
        return arrayListOfPlanesParameters;
    }

    private void setArrayListOfPlanesParameters(ArrayList<String> arrayListOfPlanesParameters)
            throws ReaderOfPlanesFromTxtFileException {
        try {
            if (!arrayListOfPlanesParameters.isEmpty()) {
                LOGGER.debug("File isn't empty. Can initialize array list of strings");
                this.arrayListOfPlanesParameters = arrayListOfPlanesParameters;
            } else {
                LOGGER.debug("File is empty. Can't initialize array list of strings");
                throw new IOException();
            }
        } catch (IOException e) {
            throw new ReaderOfPlanesFromTxtFileException();
        }

    }

    private ArrayList<String> readFromTxtFile() throws ReaderOfPlanesFromTxtFileException {
        try {
            if (new File(filename).exists()) {
                LOGGER.debug("File exists");
                return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            } else {
                LOGGER.error("File doesn't exist");
                throw new IOException();
            }
        } catch (IOException e) {
            throw new ReaderOfPlanesFromTxtFileException();
        }
    }

    @Override
    public String toString() {
        return "ReaderOfPlanesFromTxtFile{" +
                "arrayListOfPlanesParameters=" + arrayListOfPlanesParameters +
                '}';
    }
}

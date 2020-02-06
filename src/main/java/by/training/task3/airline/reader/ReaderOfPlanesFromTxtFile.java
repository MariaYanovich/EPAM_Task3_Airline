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

    private ArrayList<String> arrayListOfPlanes;
    private String filename;

    public ReaderOfPlanesFromTxtFile() {
        this.arrayListOfPlanes = new ArrayList<>();
        this.filename = ".\\src\\main\\resources\\Planes.txt";
        try {
            setArrayListOfPlanes(readFromTxtFile());
        } catch (ReaderOfPlanesFromTxtFileException e) {
            LOGGER.error("File is empty. Repository will be empty at start.");
        }
    }

    private ArrayList<String> readFromTxtFile() throws ReaderOfPlanesFromTxtFileException {
        try {
            if (new File(filename).exists()) {
                LOGGER.info("File exists");
                return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            } else {
                LOGGER.error("File doesn't exist");
                throw new IOException();
            }
        } catch (IOException e) {
            throw new ReaderOfPlanesFromTxtFileException();
        }
    }

    public String getStrWithPlane(int i) {
        return arrayListOfPlanes.get(i);
    }

    public ArrayList<String> getArrayListOfPlanes() {
        return arrayListOfPlanes;
    }

    private void setArrayListOfPlanes(ArrayList<String> arrayListOfPlanes)
            throws ReaderOfPlanesFromTxtFileException {
        try {
            if (!arrayListOfPlanes.isEmpty()) {
                LOGGER.info("File isn't empty. Can initialize array list of strings");
                this.arrayListOfPlanes = arrayListOfPlanes;
            } else {
                LOGGER.error("File is empty. Can't initialize array list of strings");
                throw new IOException();
            }
        } catch (IOException e) {
            throw new ReaderOfPlanesFromTxtFileException();
        }

    }
}


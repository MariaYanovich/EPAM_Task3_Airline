package by.training.task3.airline.repository.impl;

import by.training.task3.airline.entity.Plane;

import by.training.task3.airline.factory.PlaneFactory;
import by.training.task3.airline.reader.ReaderOfPlanesFromTxtFile;

import by.training.task3.airline.repository.AirlineRepository;
import by.training.task3.airline.specification.PlaneSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;


public class AirlineRepositoryImpl implements AirlineRepository {

    private static final Logger LOGGER = LogManager.getLogger(AirlineRepositoryImpl.class.getName());

    private ArrayList<Plane> airline = new ArrayList<>();
    private HashSet<Integer> idList = new HashSet<>();

    private AirlineRepositoryImpl() {
        initializeAirlineRepository();
    }

    private static class AirlineRepositoryHolder {
        private final static AirlineRepositoryImpl instance = new AirlineRepositoryImpl();
    }

    private void initializeAirlineRepository() {
        ReaderOfPlanesFromTxtFile txtFile = new ReaderOfPlanesFromTxtFile();
        PlaneFactory planeFactory = new PlaneFactory();
        for (int i = 0; i < txtFile.getArrayListOfPlanesParameters().size(); i++) {
            Plane tmpPlane = planeFactory.getPlane(txtFile.getArrayListOfPlanesParameters().get(i));
            addPlane(tmpPlane);
        }
    }

    public static AirlineRepositoryImpl getInstance() {
        return AirlineRepositoryHolder.instance;
    }

    @Override
    public void addPlane(Plane plane) {
        if (Optional.ofNullable(plane).isPresent() && plane.getId() != 0
                && !airline.contains(plane) && !idList.contains(plane.getId())) {
            airline.add(plane);
            idList.add(plane.getId());
            LOGGER.debug("Add to repository: " + plane);
        } else {
            LOGGER.error("Didn't add this plane information to repository");
        }
    }

    @Override
    public void removePlane(Plane plane) {
        if (Optional.ofNullable(plane).isPresent() && airline.contains(plane)) {
            airline.remove(plane);
            LOGGER.debug("Remove from repository: " + plane);
        } else {
            LOGGER.debug("Didn't remove from repository: " + plane);
        }
    }

    @Override
    public void updatePlane(Plane oldPlane, Plane newPlane) {
        if (airline.contains(oldPlane) && Optional.ofNullable(oldPlane).isPresent()
                && Optional.ofNullable(newPlane).isPresent()) {
            airline.set(airline.indexOf(oldPlane), newPlane);
            LOGGER.debug("Update plane with id " + oldPlane.getId() +
                    " to " + newPlane);
        } else {
            LOGGER.debug("Didn't update plane");
        }
    }

    public ArrayList<Plane> getAllPlanesOfAirline() {
        return airline;
    }

    public ArrayList<Plane> query(PlaneSpecification specification) {
        LOGGER.debug("Get planes by specification: " + specification.getClass().getSimpleName());
        return specification.specified(getAllPlanesOfAirline());
    }

    public double sumAllTakeoffWeight() {
        double sumToReturn = 0;
        for (Plane plane : getAllPlanesOfAirline()) {
            sumToReturn += plane.getTakeoffWeight();
        }
        LOGGER.debug("Sum all takeoff weight was successful. Result is " + sumToReturn);
        return sumToReturn;
    }

    public int sumAllPassengerCapacity() {
        int sumToReturn = 0;
        for (Plane plane : getAllPlanesOfAirline()) {
            sumToReturn += plane.getPassengerCapacity();
        }
        LOGGER.debug("Sum all passenger capacity was successful. Result is " + sumToReturn);
        return sumToReturn;
    }

}

package by.training.task3.airline.service.impl;

import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.factory.PlaneFactory;
import by.training.task3.airline.reader.ReaderOfPlanesFromTxtFile;
import by.training.task3.airline.repository.AirlineRepository;
import by.training.task3.airline.repository.impl.AirlineRepositoryImpl;
import by.training.task3.airline.service.AirlineService;
import by.training.task3.airline.specification.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import static by.training.task3.airline.creator.CreatePlaneFromStringArray.getPlaneType;
import static by.training.task3.airline.creator.CreatePlaneFromStringArray.splitStringIntoArrOfString;

public class AirlineServiceImpl implements AirlineService {

    private static final Logger LOGGER = LogManager.getLogger(AirlineServiceImpl.class.getName());

    private AirlineRepository repository = AirlineRepositoryImpl.getInstance();
    private HashSet<Integer> idList = new HashSet<>();

    private AirlineServiceImpl() {
        addAllPlanesFromFile();
    }

    public static AirlineServiceImpl getInstance() {
        return AirlineServiceHolder.instance;
    }

    private void addAllPlanesFromFile() {
        ReaderOfPlanesFromTxtFile file = new ReaderOfPlanesFromTxtFile();
        PlaneFactory planeFactory = new PlaneFactory();
        for (int i = 0; i < file.getArrayListOfPlanes().size(); i++) {
            addPlane(planeFactory.createPlane(getPlaneType(file.getStrWithPlane(i)),
                    splitStringIntoArrOfString(file.getStrWithPlane(i))));
        }
    }

    public void addPlane(Plane plane) {
        if (Optional.ofNullable(plane).isPresent()
                && !repository.getAllPlanesOfAirline().contains(plane)
                && plane.getId() != 0
                && !idList.contains(plane.getId())) {
            repository.addPlane(plane);
            idList.add(plane.getId());
            LOGGER.debug("Add to repository: " + plane);
        } else {
            LOGGER.error("Didn't add this plane information to repository" + plane);
        }
    }

    public void removePlane(Plane plane) {
        if (Optional.ofNullable(plane).isPresent() &&
                repository.getAllPlanesOfAirline().contains(plane)) {
            repository.removePlane(plane);
            LOGGER.debug("Remove from repository: " + plane);
        } else {
            LOGGER.debug("Didn't remove from repository: " + plane);
        }
    }

    public void updatePlane(Plane oldPlane, Plane newPlane) {
        if (repository.getAllPlanesOfAirline().contains(oldPlane)
                && Optional.ofNullable(oldPlane).isPresent()
                && Optional.ofNullable(newPlane).isPresent()) {
            repository.updatePlane(oldPlane, newPlane);
            LOGGER.debug("Update plane with id " + oldPlane.getId() +
                    " to " + newPlane);
        } else {
            LOGGER.debug("Didn't update plane");
        }
    }

    public ArrayList<Plane> getAllPlanes() {
        return repository.getAllPlanesOfAirline();
    }

    @Override
    public ArrayList<Plane> getPlaneById(int id) {
        return repository.query(new FindPlaneById(id));
    }

    public ArrayList<Plane> getPlaneFromPassengerCapacityRange(int startOfRange, int endOfRange) {
        return repository.query(new FindPlaneFromPassengerCapacityInterval(startOfRange, endOfRange));
    }

    public ArrayList<Plane> findPlaneWithMaxSpeed() {
        return repository.query(new FindPlaneWithMaxSpeed());
    }

    public ArrayList<Plane> sortByFlightDistance() {
        return repository.query(new SortByFlightDistance());
    }

    public ArrayList<Plane> sortByFlightDistanceAndTypeOfPlane() {
        return repository.query(new SortByFlightDistanceAndTypeOfPlane());
    }

    public double sumAllTakeoffWeight() {
        double sumToReturn = 0;
        for (Plane plane : repository.getAllPlanesOfAirline()) {
            sumToReturn += plane.getTakeoffWeight();
        }
        LOGGER.debug("Sum all takeoff weight was successful. Result is " + sumToReturn);
        return sumToReturn;
    }

    public int sumAllPassengerCapacity() {
        int sumToReturn = 0;
        for (Plane plane : repository.getAllPlanesOfAirline()) {
            sumToReturn += plane.getPassengerCapacity();
        }
        LOGGER.debug("Sum all passenger capacity was successful. Result is " + sumToReturn);
        return sumToReturn;
    }

    public AirlineRepository getRepository() {
        return repository;
    }

    @Override
    public String toString() {
        String str = "";
        for (Plane s : repository.getAllPlanesOfAirline()) {
            str = str.concat(s.toString()).concat("\n");
        }
        return "AirlineServiceImpl{" +
                "repository=" + "\n" + str +
                '}';
    }

    private static class AirlineServiceHolder {
        private final static AirlineServiceImpl instance = new AirlineServiceImpl();
    }
}

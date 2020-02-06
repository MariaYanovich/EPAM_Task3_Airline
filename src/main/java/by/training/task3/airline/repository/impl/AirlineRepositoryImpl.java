package by.training.task3.airline.repository.impl;

import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.repository.AirlineRepository;
import by.training.task3.airline.specification.PlaneSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class AirlineRepositoryImpl implements AirlineRepository {

    private static final Logger LOGGER = LogManager.getLogger(AirlineRepositoryImpl.class.getName());

    private ArrayList<Plane> airline = new ArrayList<>();

    private AirlineRepositoryImpl() {
    }

    public static AirlineRepositoryImpl getInstance() {
        return AirlineRepositoryHolder.instance;
    }

    @Override
    public void addPlane(Plane plane) {
        airline.add(plane);
    }

    @Override
    public void removePlane(Plane plane) {
        airline.remove(plane);
    }

    @Override
    public void updatePlane(Plane oldPlane, Plane newPlane) {
        airline.set(airline.indexOf(oldPlane), newPlane);
    }

    public ArrayList<Plane> getAllPlanesOfAirline() {
        return airline;
    }

    public ArrayList<Plane> query(PlaneSpecification specification) {
        LOGGER.debug("Get planes by specification: " + specification.getClass().getSimpleName());
        return specification.specified(getAllPlanesOfAirline());
    }

    private static class AirlineRepositoryHolder {
        private final static AirlineRepositoryImpl instance = new AirlineRepositoryImpl();
    }
}

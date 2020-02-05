package by.training.task3.airline.service.impl;

import by.training.task3.airline.entity.Plane;

import by.training.task3.airline.repository.AirlineRepository;
import by.training.task3.airline.repository.impl.AirlineRepositoryImpl;
import by.training.task3.airline.service.AirlineService;
import by.training.task3.airline.specification.impl.*;

import java.util.ArrayList;

public class AirlineServiceImpl implements AirlineService {

    private AirlineRepository repository = AirlineRepositoryImpl.getInstance();

    public void addPlane(Plane plane) {
        repository.addPlane(plane);
    }

    public void removePlane(Plane plane) {
        repository.removePlane(plane);
    }

    public void updatePlane(Plane oldPlane, Plane newPlane) {
        repository.updatePlane(oldPlane, newPlane);
    }

    public ArrayList<Plane> getAllPlanes() {
        return repository.getAllPlanes();
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
        return repository.sumAllTakeoffWeight();
    }

    public int sumAllPassengerCapacity() {
        return repository.sumAllPassengerCapacity();
    }

    @Override
    public String toString() {
        String str = "";
        for (Plane s : repository.getAllPlanes()) {
            str = str.concat(s.toString()).concat("\n");
        }
        return "AirlineServiceImpl{" +
                "repository=" + "\n" + str +
                '}';
    }
}

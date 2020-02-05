package by.training.task3.airline.service;

import by.training.task3.airline.entity.Plane;

import java.util.ArrayList;

public interface AirlineService {
    void addPlane(Plane plane);

    void removePlane(Plane plane);

    void updatePlane(Plane oldPlane, Plane newPlane);

    ArrayList<Plane> getAllPlanes();

    ArrayList<Plane> getPlaneById(int id);

    ArrayList<Plane> getPlaneFromPassengerCapacityRange(int startOfRange, int endOfRange);

    ArrayList<Plane> findPlaneWithMaxSpeed();

    ArrayList<Plane> sortByFlightDistance();

    ArrayList<Plane> sortByFlightDistanceAndTypeOfPlane();

    int sumAllPassengerCapacity();

    double sumAllTakeoffWeight();


}

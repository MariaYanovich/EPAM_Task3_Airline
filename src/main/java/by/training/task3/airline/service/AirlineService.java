package by.training.task3.airline.service;

import by.training.task3.airline.entity.Plane;

import java.util.ArrayList;

public interface AirlineService {
    void addPlane(Plane plane);

    void removePlane(Plane plane);

    void updatePlane(Plane oldPlane, Plane newPlane);

    boolean searchPlane(Plane plane);

    ArrayList<Plane> getAllPlanes();

    ArrayList<Plane> getPlaneFromPassengerCapacityRange(int startOfRange, int endOfRange);

    Plane findPlaneWithMaxSpeed();

    int sumAllPassengerCapacity();

    double sumAllMaximumTakeOffWeight();

    ArrayList<Plane> sortByPracticalFlightDistance();

    ArrayList<Plane> sortByPracticalFlightDistanceAndTypeOfPlane();
}

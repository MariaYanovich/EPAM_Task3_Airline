package by.training.task3.airline.repository;

import by.training.task3.airline.entity.Plane;

import java.util.ArrayList;

public interface AirlineRepository {
    void addPlane(Plane plane);

    void removePlane(Plane plane);

    void updatePlane(Plane oldPlane, Plane newPlane);

    boolean searchPlane(Plane plane);

    Plane getPlaneById(int id);

    ArrayList<Plane> getAllPlanes();

    // List query(PlaneSpecification specification);
}

package by.training.task3.airline.repository;

import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.specification.PlaneSpecification;

import java.util.ArrayList;

public interface AirlineRepository {
    void addPlane(Plane plane);

    void removePlane(Plane plane);

    void updatePlane(Plane oldPlane, Plane newPlane);

    ArrayList<Plane> getAllPlanesOfAirline();

    ArrayList<Plane> query(PlaneSpecification specification);

}

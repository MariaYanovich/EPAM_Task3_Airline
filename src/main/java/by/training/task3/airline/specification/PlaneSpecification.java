package by.training.task3.airline.specification;

import by.training.task3.airline.entity.Plane;

import java.util.ArrayList;

public interface PlaneSpecification {
    ArrayList<Plane> specified(ArrayList<Plane> planesOfRepository);
}

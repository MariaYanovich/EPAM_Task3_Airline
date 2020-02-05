package by.training.task3.airline.comparator;

import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.enums.PlaneTypes;

import java.util.Comparator;

public class PlaneComparatorByTypeOfPlane implements Comparator<Plane> {
    @Override
    public int compare(Plane o1, Plane o2) {
        if (o1.getTypeOfPlane() == o2.getTypeOfPlane()) {
            return 0;
        } else {
            return -1;
        }
    }
}

package by.training.task3.airline.comparator;

import by.training.task3.airline.entity.Plane;

import java.util.Comparator;

public class PlaneComparatorByPracticalFlightDistance implements Comparator<Plane> {
    @Override
    public int compare(Plane o1, Plane o2) {
        return Double.compare(o1.getPracticalFlightDistance(), o2.getPracticalFlightDistance());
    }
}

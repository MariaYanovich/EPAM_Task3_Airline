package by.training.task3.airline.specification.impl;

import by.training.task3.airline.comparator.ComparatorByFlightDistance;
import by.training.task3.airline.comparator.ComparatorByTypeOfPlane;
import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.specification.PlaneSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByFlightDistanceAndTypeOfPlane implements PlaneSpecification {
    private static final Logger LOGGER = LogManager.getLogger(SortByFlightDistanceAndTypeOfPlane.class.getName());

    @Override
    public ArrayList<Plane> specified(ArrayList<Plane> planesOfRepository) {
        Comparator<Plane> planeComparator
                = new ComparatorByFlightDistance().thenComparing(
                new ComparatorByTypeOfPlane());
        ArrayList<Plane> listToReturn = new ArrayList<>(planesOfRepository);
        listToReturn.sort(planeComparator);
        LOGGER.debug("Result of sort: " + listToReturn);
        return listToReturn;
    }
}

package by.training.task3.airline.specification.impl;

import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.specification.PlaneSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FindPlaneWithMaxSpeed implements PlaneSpecification {
    private static final Logger LOGGER = LogManager.getLogger(FindPlaneWithMaxSpeed.class.getName());

    @Override
    public ArrayList<Plane> specified(ArrayList<Plane> planesOfRepository) {
        double maxSpeed = findMax(planesOfRepository);
        ArrayList<Plane> listToReturn = new ArrayList<>();
        for (Plane plane : planesOfRepository) {
            if (plane.getSpeed() == maxSpeed) {
                listToReturn.add(plane);
            }
        }
        LOGGER.debug("Find plane with max speed is ended: " + listToReturn);
        return listToReturn;
    }

    private double findMax(ArrayList<Plane> list) {
        double maxSpeed = Double.MIN_VALUE;
        for (Plane plane : list) {
            if (plane.getSpeed() > maxSpeed) {
                maxSpeed = plane.getSpeed();
            }
        }
        return maxSpeed;
    }

}

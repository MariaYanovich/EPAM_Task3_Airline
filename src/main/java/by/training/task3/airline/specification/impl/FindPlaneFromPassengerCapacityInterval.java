package by.training.task3.airline.specification.impl;

import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.specification.PlaneSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FindPlaneFromPassengerCapacityInterval implements PlaneSpecification {
    private static final Logger LOGGER = LogManager.
            getLogger(FindPlaneFromPassengerCapacityInterval.class.getName());

    private int startOfInterval;
    private int endOfInterval;

    public FindPlaneFromPassengerCapacityInterval(int startOfInterval,
                                                  int endOfInterval) {
        this.startOfInterval = startOfInterval;
        this.endOfInterval = endOfInterval;
    }

    @Override
    public ArrayList<Plane> specified(ArrayList<Plane> planesOfRepository) {
        ArrayList<Plane> listToReturn = new ArrayList<>();
        for (Plane plane : planesOfRepository) {
            if (plane.getPassengerCapacity() >= startOfInterval
                    && plane.getPassengerCapacity() <= endOfInterval) {
                listToReturn.add(plane);
            }
        }

        LOGGER.debug("Find plane in interval is ended: " + listToReturn);

        return listToReturn;
    }
}

package by.training.task3.airline.specification.impl;

import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.specification.PlaneSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FindPlaneById implements PlaneSpecification {

    private static final Logger LOGGER = LogManager.getLogger(FindPlaneById.class.getName());

    private int id;

    public FindPlaneById(int id) {
        this.id = id;
    }

    @Override
    public ArrayList<Plane> specified(ArrayList<Plane> planesOfRepository) {
        ArrayList<Plane> listToReturn = new ArrayList<>();
        for (Plane plane : planesOfRepository) {
            if (plane.getId() == id) {
                listToReturn.add(plane);
            }
        }
        LOGGER.debug("Find plane by id is ended: " + listToReturn);
        return listToReturn;
    }
}

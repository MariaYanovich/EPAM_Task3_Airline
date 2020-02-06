package by.training.task3.airline.factory;

import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.enums.PlaneType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.training.task3.airline.creator.CreatePlaneFromStringArray.createPassengerPlane;
import static by.training.task3.airline.creator.CreatePlaneFromStringArray.createTransportPlane;


public class PlaneFactory {

    private static Logger LOGGER = LogManager.getLogger(PlaneFactory.class.getName());

    public Plane createPlane(PlaneType planeType, String[] arr) {
        Plane plane = null;
        switch (planeType) {
            case PASSENGER:
                LOGGER.debug("Start creating passenger plane..");
                plane = createPassengerPlane(arr);
                break;
            case TRANSPORT:
                LOGGER.debug("Start creating transport plane..");
                plane = createTransportPlane(arr);
                break;

        }
        return plane;
    }
}


package by.training.task3.airline.factory;

import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.enums.PlaneTypes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.training.task3.airline.initializer.InitializerOfPlaneFactory.*;


public class PlaneFactory {

    private static Logger LOGGER = LogManager.getLogger(PlaneFactory.class.getName());

    public Plane getPlane(String strFromFile) {
        String[] arr = strFromFile.split(" ");
        Plane plane = null;
        if (isInformationFull(arr)) {
            try {
                switch (PlaneTypes.valueOf(arr[1])) {
                    case PASSENGER:
                        LOGGER.debug("Start creating passenger plane..");
                        plane = initializePassengerPlane(arr);
                        break;
                    case TRANSPORT:
                        LOGGER.debug("Start creating transport plane..");
                        plane = initializeTransportPlane(arr);
                        break;
                }
            } catch (IllegalArgumentException e) {
                LOGGER.error("There is no type of plane like: " + arr[1]);
            }
        }
        return plane;
    }
}


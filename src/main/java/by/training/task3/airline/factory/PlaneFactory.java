package by.training.task3.airline.factory;

import by.training.task3.airline.entity.PassengerPlane;
import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.entity.TransportPlane;
import by.training.task3.airline.enums.PassengerPlaneTypes;
import by.training.task3.airline.enums.PlaneTypes;
import by.training.task3.airline.enums.TransportPlaneTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class PlaneFactory {

    private static Logger LOGGER = LogManager.getLogger(PlaneFactory.class.getName());
    private Plane plane;

    public Plane getPlane(String strFromFile) {
        String[] arr = strFromFile.split(" ");
        
        if (arr.length < 9) {
            LOGGER.error("There isn't full information about this plane");
            return null;
        }

        try {
            switch (PlaneTypes.valueOf(arr[1])) {
                case PASSENGER_PLANE:
                    LOGGER.debug("Create passenger plane");
                    plane = new PassengerPlane();
                    if (initializePassengerPlane((PassengerPlane) plane, arr) &&
                            initializeForAllCommonFields(arr)) {
                        initializeForAllCommonFields(arr);
                        initializePassengerPlane((PassengerPlane) plane, arr);
                    } else {
                        plane = null;
                    }
                    break;
                case TRANSPORT_PLANE:
                    LOGGER.debug("Create transport plane");
                    plane = new TransportPlane();
                    if (initializeForAllCommonFields(arr) &&
                            initializeTransportPlane((TransportPlane) plane, arr)) {
                        initializeForAllCommonFields(arr);
                        initializeTransportPlane((TransportPlane) plane, arr);
                    } else {
                        plane = null;
                    }
                    break;
                default:
                    LOGGER.error("Wrong plane type.");
                    throw new IllegalArgumentException("Wrong plane type:" + arr[0]);
            }
        } catch (IllegalArgumentException e) {
            LOGGER.error("There is no such type of plane");
        }
        return plane;
    }

    private boolean initializeForAllCommonFields(String[] arr) {
        try {
            plane.setId(Integer.parseInt(arr[0]));
            plane.setPassengerCapacity(Integer.parseInt(arr[2]));
            plane.setMaximumTakeoffWeight(Double.parseDouble(arr[3]));
            plane.setMaximumSpeed(Double.parseDouble(arr[4]));
            plane.setPracticalFlightDistance(Double.parseDouble(arr[5]));
            plane.setWeightOfEmptyPlane(Double.parseDouble(arr[6]));
            return true;
        } catch (NumberFormatException e) {
            LOGGER.error("Cant't parse data for current plane");
        }
        return false;
    }

    private boolean initializePassengerPlane(PassengerPlane plane, String[] arr) {
        try {
            plane.setNumberOfStewards(Integer.parseInt(arr[7]));
            plane.setTypeOfPassengerPlane(PassengerPlaneTypes.valueOf(arr[8]));
            return true;
        } catch (NumberFormatException e) {
            LOGGER.error("Cant't parse data for passenger plane. Update to default value");
        } catch (IllegalArgumentException i) {
            LOGGER.error("There is no such type of passenger plane");
        }
        return false;
    }

    private boolean initializeTransportPlane(TransportPlane plane, String[] arr) {
        try {
            plane.setVolumeOfAirContainer(Double.parseDouble(arr[7]));
            plane.setTypeOfTransportPlane(TransportPlaneTypes.valueOf(arr[8]));
            return true;
        } catch (NumberFormatException e) {
            LOGGER.error("Cant't parse data for transport plane");
        } catch (IllegalArgumentException i) {
            LOGGER.error("There is no such type of transport plane");
        }
        return false;
    }
}


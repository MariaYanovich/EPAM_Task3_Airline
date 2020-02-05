package by.training.task3.airline.initializer;

import by.training.task3.airline.entity.PassengerPlane;
import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.entity.TransportPlane;
import by.training.task3.airline.enums.PassengerPlaneTypes;
import by.training.task3.airline.enums.TransportPlaneTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InitializerOfPlaneFactory {

    private static Logger LOGGER = LogManager.getLogger(InitializerOfPlaneFactory.class.getName());

    private static void initializeForAllCommonFields(Plane plane, String[] arr) {
        plane.setId(Integer.parseInt(arr[0]));
        plane.setPassengerCapacity(Integer.parseInt(arr[2]));
        plane.setTakeoffWeight(Double.parseDouble(arr[3]));
        plane.setSpeed(Double.parseDouble(arr[4]));
        plane.setFlightDistance(Double.parseDouble(arr[5]));
    }

    public static boolean isInformationFull(String[] arrWithParameters) {
        if (arrWithParameters.length < 8) {
            LOGGER.error("There isn't full information about this plane");
            return false;
        }
        return true;
    }

    public static PassengerPlane initializePassengerPlane(String[] arr) {
        PassengerPlane plane = new PassengerPlane();
        try {
            initializeForAllCommonFields(plane, arr);
            plane.setNumberOfStewards(Integer.parseInt(arr[6]));
            plane.setTypeOfPassengerPlane(PassengerPlaneTypes.valueOf(arr[7]));
            return plane;
        } catch (NumberFormatException e) {
            LOGGER.error("Cant't parse data for passenger plane.");
        } catch (IllegalArgumentException i) {
            LOGGER.error("There is no such type of passenger plane");
        }
        return null;
    }

    public static TransportPlane initializeTransportPlane(String[] arr) {
        TransportPlane plane = new TransportPlane();
        try {
            initializeForAllCommonFields(plane, arr);
            plane.setVolumeOfContainer(Double.parseDouble(arr[6]));
            plane.setTypeOfTransportPlane(TransportPlaneTypes.valueOf(arr[7]));
            return plane;
        } catch (NumberFormatException e) {
            LOGGER.error("Cant't parse data for transport plane");
        } catch (IllegalArgumentException i) {
            LOGGER.error("There is no such type of transport plane");
        }
        return null;
    }
}

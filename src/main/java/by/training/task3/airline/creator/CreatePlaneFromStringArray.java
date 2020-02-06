package by.training.task3.airline.creator;

import by.training.task3.airline.entity.PassengerPlane;
import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.entity.TransportPlane;
import by.training.task3.airline.enums.PassengerPlaneType;
import by.training.task3.airline.enums.PlaneType;
import by.training.task3.airline.enums.TransportPlaneType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.training.task3.airline.validator.ValidatorForPlaneParameters.*;

public class CreatePlaneFromStringArray {

    private static Logger LOGGER = LogManager.getLogger(CreatePlaneFromStringArray.class.getName());

    private static void initializeForAllCommonFields(Plane plane, String[] arr) {
        if (isParseArrayElementsGreaterThanZero(arr)) {
            plane.setId(Integer.parseInt(arr[0]));
            plane.setPassengerCapacity(Integer.parseInt(arr[2]));
            plane.setTakeoffWeight(Double.parseDouble(arr[3]));
            plane.setSpeed(Double.parseDouble(arr[4]));
            plane.setFlightDistance(Double.parseDouble(arr[5]));
        }
    }

    public static PassengerPlane createPassengerPlane(String[] arr) {
        PassengerPlane plane = new PassengerPlane();
        try {
            initializeForAllCommonFields(plane, arr);
            if (isGreaterThanZero(Integer.parseInt(arr[6]))) {
                plane.setNumberOfStewards(Integer.parseInt(arr[6]));
            }
            plane.setTypeOfPassengerPlane(PassengerPlaneType.valueOf(arr[7]));
            return plane;
        } catch (NumberFormatException e) {
            LOGGER.error("Cant't parse data for passenger plane.");
        } catch (IllegalArgumentException i) {
            LOGGER.error("There is no such type of passenger plane");
        }
        return null;
    }

    public static TransportPlane createTransportPlane(String[] arr) {
        TransportPlane plane = new TransportPlane();
        try {
            initializeForAllCommonFields(plane, arr);
            if (isGreaterThanZero(Double.parseDouble(arr[6]))) {
                plane.setVolumeOfContainer(Double.parseDouble(arr[6]));
            } else {
                throw new NumberFormatException();
            }
            plane.setTypeOfTransportPlane(TransportPlaneType.valueOf(arr[7]));
            return plane;
        } catch (NumberFormatException e) {
            LOGGER.error("Cant't parse data for transport plane");
        } catch (IllegalArgumentException i) {
            LOGGER.error("There is no such type of transport plane");
        }
        return null;

    }

    public static PlaneType getPlaneType(String strWithPlaneParameters) {
        String[] arrWithPlaneParameters = splitStringIntoArrOfString(strWithPlaneParameters);
        if (isInformationFull(arrWithPlaneParameters)) {
            try {
                for (PlaneType type : PlaneType.values()) {
                    if (type.toString().equals(arrWithPlaneParameters[1])) {
                        return type;
                    }
                }
            } catch (ExceptionInInitializerError e) {
                LOGGER.error("There is no type of plane like: " + arrWithPlaneParameters[1]);
            }
        }
        return PlaneType.DEFAULT;
    }

    public static String[] splitStringIntoArrOfString(String str) {
        return str.split(" ");
    }

}


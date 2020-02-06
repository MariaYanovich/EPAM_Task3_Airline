package by.training.task3.airline.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ValidatorForPlaneParameters {
    private static final Logger LOGGER = LogManager.getLogger(ValidatorForPlaneParameters.class.getName());


    public static boolean isInformationFull(String[] arrWithParameters) {
        if (arrWithParameters.length < 8) {
            LOGGER.error("There isn't full information about this plane");
            return false;
        }
        return true;
    }


    public static boolean isGreaterThanZero(int number) {
        return number >= 0;
    }

    public static boolean isParseArrayElementsGreaterThanZero(String[] arr) {
        return isGreaterThanZero(Integer.parseInt(arr[0]))
                && isGreaterThanZero(Integer.parseInt(arr[2]))
                && (isGreaterThanZero(Double.parseDouble(arr[3])))
                && isGreaterThanZero(Double.parseDouble(arr[4]))
                && isGreaterThanZero(Double.parseDouble(arr[5]));
    }

    public static boolean isGreaterThanZero(double number) {
        return number >= 0;
    }

}

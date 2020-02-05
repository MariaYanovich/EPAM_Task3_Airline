package by.training.task3.airline.specification.impl;

import by.training.task3.airline.comparator.ComparatorByFlightDistance;
import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.specification.PlaneSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class SortByFlightDistance implements PlaneSpecification {

    private static final Logger LOGGER = LogManager.getLogger(SortByFlightDistance.class.getName());

    @Override
    public ArrayList<Plane> specified(ArrayList<Plane> planesOfRepository) {
        ComparatorByFlightDistance planeComparator
                = new ComparatorByFlightDistance();
        ArrayList<Plane> listToReturn = new ArrayList<>(planesOfRepository);
        listToReturn.sort(planeComparator);
//        String str = "";
//        for (Plane s : listToReturn) {
//            str = str.concat(s.toString()).concat("\n");
//        }
//        LOGGER.debug("Result of sort: \n" + str);
        LOGGER.debug("Result of sort:" + listToReturn);
        return listToReturn;
    }
}

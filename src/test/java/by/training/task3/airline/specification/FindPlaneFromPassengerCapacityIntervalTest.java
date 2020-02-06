package by.training.task3.airline.specification;

import by.training.task3.airline.entity.PassengerPlane;
import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.entity.TransportPlane;
import by.training.task3.airline.specification.impl.FindPlaneFromPassengerCapacityInterval;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static by.training.task3.airline.enums.PassengerPlaneType.BUSINESS;
import static by.training.task3.airline.enums.PassengerPlaneType.ECONOMY;
import static by.training.task3.airline.enums.PlaneType.PASSENGER;
import static by.training.task3.airline.enums.PlaneType.TRANSPORT;
import static by.training.task3.airline.enums.TransportPlaneType.CIVILIAN;
import static by.training.task3.airline.enums.TransportPlaneType.MILITARY;
import static org.junit.Assert.assertEquals;

public class FindPlaneFromPassengerCapacityIntervalTest {

    private ArrayList<Plane> listOfPlanes = new ArrayList<>();

    @Before
    public void testInitializeExpectedArrayListOfPlanes() {
        listOfPlanes.add(new PassengerPlane(1, PASSENGER, 100, 3400, 900, 2000, 5, ECONOMY));
        listOfPlanes.add(new TransportPlane(2, TRANSPORT, 2, 5000, 950, 2500, 3.6, MILITARY));
        listOfPlanes.add(new PassengerPlane(3, PASSENGER, 80, 3470, 970, 2600, 5, BUSINESS));
        listOfPlanes.add(new TransportPlane(4, TRANSPORT, 4, 4000, 950, 2500, 5.9, CIVILIAN));
    }

    @Test
    public void testSpecified() {
        ArrayList<Plane> expectedList = new ArrayList<>();
        expectedList.add(listOfPlanes.get(1));
        expectedList.add(listOfPlanes.get(3));
        FindPlaneFromPassengerCapacityInterval findPlaneFromPassengerCapacityInterval
                = new FindPlaneFromPassengerCapacityInterval(0, 5);
        assertEquals(expectedList,
                findPlaneFromPassengerCapacityInterval.specified(listOfPlanes));
    }
}
package by.training.task3.airline.comparator;

import by.training.task3.airline.entity.PassengerPlane;
import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.entity.TransportPlane;
import by.training.task3.airline.specification.impl.FindPlaneById;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static by.training.task3.airline.enums.PassengerPlaneTypes.BUSINESS;
import static by.training.task3.airline.enums.PassengerPlaneTypes.ECONOMY;
import static by.training.task3.airline.enums.PlaneTypes.PASSENGER;
import static by.training.task3.airline.enums.PlaneTypes.TRANSPORT;
import static by.training.task3.airline.enums.TransportPlaneTypes.CIVILIAN;
import static by.training.task3.airline.enums.TransportPlaneTypes.MILITARY;
import static org.junit.Assert.*;

public class ComparatorByTypeOfPlaneTest {

    private ComparatorByTypeOfPlane comparator = new ComparatorByTypeOfPlane();

    @Test
    public void compare() {
        PassengerPlane p1 = new PassengerPlane(1, PASSENGER, 100, 3400, 900, 2000, 5, ECONOMY);
        TransportPlane p2 = new TransportPlane(2, TRANSPORT, 2, 5000, 950, 2500, 3.6, MILITARY);
        int expected = -1;
        assertEquals(expected, comparator.compare(p1, p2));
    }
}
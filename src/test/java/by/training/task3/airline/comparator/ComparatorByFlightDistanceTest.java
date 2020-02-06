package by.training.task3.airline.comparator;

import by.training.task3.airline.entity.PassengerPlane;
import by.training.task3.airline.entity.TransportPlane;
import org.junit.Test;

import static by.training.task3.airline.enums.PassengerPlaneTypes.ECONOMY;
import static by.training.task3.airline.enums.PlaneTypes.PASSENGER;
import static by.training.task3.airline.enums.PlaneTypes.TRANSPORT;
import static by.training.task3.airline.enums.TransportPlaneTypes.MILITARY;
import static org.junit.Assert.*;

public class ComparatorByFlightDistanceTest {

    private ComparatorByFlightDistance comparator = new ComparatorByFlightDistance();

    @Test
    public void compare() {
        TransportPlane p1 = new TransportPlane(1, TRANSPORT, 2, 5000, 950, 2500, 3.6, MILITARY);
        PassengerPlane p2 = new PassengerPlane(2, PASSENGER, 100, 3400, 900, 2000, 5, ECONOMY);
        int expected = 1;
        assertEquals(expected, comparator.compare(p1, p2));
    }
}
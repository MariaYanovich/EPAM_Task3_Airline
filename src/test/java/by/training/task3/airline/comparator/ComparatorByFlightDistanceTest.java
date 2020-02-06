package by.training.task3.airline.comparator;

import by.training.task3.airline.entity.PassengerPlane;
import by.training.task3.airline.entity.TransportPlane;
import org.junit.Before;
import org.junit.Test;

import static by.training.task3.airline.enums.PassengerPlaneType.ECONOMY;
import static by.training.task3.airline.enums.PlaneType.PASSENGER;
import static by.training.task3.airline.enums.PlaneType.TRANSPORT;
import static by.training.task3.airline.enums.TransportPlaneType.MILITARY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ComparatorByFlightDistanceTest {

    private ComparatorByFlightDistance comparator;
    private PassengerPlane planeOne;
    private TransportPlane planeTwo;

    @Before
    public void initialize() {
        comparator = new ComparatorByFlightDistance();
        planeOne = new PassengerPlane(1, PASSENGER, 100, 3400, 900, 2500, 5, ECONOMY);
        planeTwo = new TransportPlane(2, TRANSPORT, 2, 5000, 950, 2000, 3.6, MILITARY);
    }

    @Test
    public void testCompareForEquals() {
        int expected = 1;
        assertEquals(expected, comparator.compare(planeOne, planeTwo));
    }

    @Test
    public void testCompareForNotEquals() {
        int expected = -1;
        assertNotEquals(expected, comparator.compare(planeOne, planeTwo));
    }
}
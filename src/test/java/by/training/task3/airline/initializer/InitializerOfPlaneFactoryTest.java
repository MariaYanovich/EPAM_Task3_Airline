package by.training.task3.airline.initializer;

import by.training.task3.airline.entity.PassengerPlane;
import by.training.task3.airline.entity.TransportPlane;
import org.junit.Test;


import static by.training.task3.airline.enums.PassengerPlaneTypes.ECONOMY;
import static by.training.task3.airline.enums.PlaneTypes.PASSENGER;
import static by.training.task3.airline.enums.PlaneTypes.TRANSPORT;
import static by.training.task3.airline.enums.TransportPlaneTypes.CARGO;
import static org.junit.Assert.*;

public class InitializerOfPlaneFactoryTest {
    InitializerOfPlaneFactory initializer = new InitializerOfPlaneFactory();

    @Test
    public void isInformationFull() {
        String[] arr = new String[]{"nas", "ds", "as", "as", "ad", "na", "d", "s", "as"};
        boolean expected = true;
        assertEquals(expected, InitializerOfPlaneFactory.isInformationFull(arr));
        expected = false;
        String[] arr2 = new String[]{"nas", "ds", "as", "as", "ad"};
        assertEquals(expected, InitializerOfPlaneFactory.isInformationFull(arr2));


    }

    @Test
    public void initializePassengerPlane() {
        String[] passengerPlane = new String[]{
                "1", "PASSENGER", "100", "3400", "900", "2000", "5", "ECONOMY"};
        PassengerPlane expectedPassengerPlane = new PassengerPlane(1, PASSENGER, 100, 3400, 900, 2000, 5, ECONOMY);
        assertEquals(expectedPassengerPlane, InitializerOfPlaneFactory.initializePassengerPlane(passengerPlane));
    }

    @Test
    public void initializeTransportPlane() {
        String[] transportPlane = new String[]{
                "1", "TRANSPORT", "100", "3400", "900", "2000", "3.4", "CARGO"};
        TransportPlane expectedTransportPlane = new TransportPlane(1, TRANSPORT, 100, 3400, 900, 2000, 3.4, CARGO);
        assertEquals(expectedTransportPlane, InitializerOfPlaneFactory.initializeTransportPlane(transportPlane));
    }
}
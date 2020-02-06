package by.training.task3.airline.creator;

import by.training.task3.airline.entity.PassengerPlane;
import by.training.task3.airline.entity.TransportPlane;
import org.junit.Test;

import static by.training.task3.airline.enums.PassengerPlaneType.ECONOMY;
import static by.training.task3.airline.enums.PlaneType.PASSENGER;
import static by.training.task3.airline.enums.PlaneType.TRANSPORT;
import static by.training.task3.airline.enums.TransportPlaneType.CARGO;
import static org.junit.Assert.assertEquals;

public class CreatePlaneFromStringArrayTest {

    @Test
    public void testInitializePassengerPlane() {
        String[] passengerPlane = new String[]{
                "1", "PASSENGER", "100", "3400", "900", "2000", "5", "ECONOMY"};
        PassengerPlane expectedPassengerPlane = new PassengerPlane(1, PASSENGER, 100, 3400, 900, 2000, 5, ECONOMY);
        assertEquals(expectedPassengerPlane, CreatePlaneFromStringArray.createPassengerPlane(passengerPlane));
    }

    @Test
    public void testInitializeTransportPlane() {
        String[] transportPlane = new String[]{
                "1", "TRANSPORT", "100", "3400", "900", "2000", "3.4", "CARGO"};
        TransportPlane expectedTransportPlane = new TransportPlane(1, TRANSPORT, 100, 3400, 900, 2000, 3.4, CARGO);
        assertEquals(expectedTransportPlane, CreatePlaneFromStringArray.createTransportPlane(transportPlane));
    }

    @Test
    public void splitStringIntoArrOfString() {
        String string = "2 type -2 4 6 3 3 type";
        String[] expectedArr = {"2", "type", "-2", "4", "6", "3", "3", "type"};
        assertEquals(expectedArr, CreatePlaneFromStringArray.splitStringIntoArrOfString(string));
    }
}
package by.training.task3.airline.service;

import by.training.task3.airline.entity.PassengerPlane;
import by.training.task3.airline.entity.Plane;

import by.training.task3.airline.entity.TransportPlane;
import by.training.task3.airline.service.impl.AirlineServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static by.training.task3.airline.enums.PassengerPlaneTypes.*;
import static by.training.task3.airline.enums.PlaneTypes.PASSENGER;
import static by.training.task3.airline.enums.PlaneTypes.TRANSPORT;
import static by.training.task3.airline.enums.TransportPlaneTypes.*;
import static org.junit.Assert.*;

public class AirlineServiceImplTest {

    private AirlineService airlineService = new AirlineServiceImpl();
    private ArrayList<Plane> listOfAirlinePlanes = new ArrayList<>();

    @Before
    public void testInitializeExpectedArrayListOfPlanes() {
        listOfAirlinePlanes.add(new PassengerPlane(1, PASSENGER, 100, 3400, 900, 2000, 5, ECONOMY));
        listOfAirlinePlanes.add(new TransportPlane(2, TRANSPORT, 2, 5000, 950, 2500, 3.6, MILITARY));
        listOfAirlinePlanes.add(new PassengerPlane(3, PASSENGER, 80, 3470, 970, 2600, 5, BUSINESS));
        listOfAirlinePlanes.add(new TransportPlane(4, TRANSPORT, 4, 4000, 950, 2500, 5.9, CIVILIAN));
        listOfAirlinePlanes.add(new PassengerPlane(6, PASSENGER, 50, 3445, 1600, 2500, 5, FIRST));
        listOfAirlinePlanes.add(new TransportPlane(8, TRANSPORT, 30, 1300, 950, 2300, 3.8, CARGO));
        listOfAirlinePlanes.add(new PassengerPlane(9, PASSENGER, 240, 3400, 1600, 2330, 5, ECONOMY));
        listOfAirlinePlanes.add(new PassengerPlane(10, PASSENGER, 150, 6300, 800, 2300, 5, BUSINESS));
        listOfAirlinePlanes.add(new TransportPlane(11, TRANSPORT, 4, 4040, 650, 2500, 4.1, MILITARY));
        listOfAirlinePlanes.add(new TransportPlane(12, TRANSPORT, 5, 4030, 1500, 2500, 4.2, CIVILIAN));
    }

    @Test
    public void testGetAllPlanes() {
        assertEquals(listOfAirlinePlanes, airlineService.getAllPlanes());
    }

    @Test
    public void testGetPlaneById() {
        ArrayList<Plane> expectedList = new ArrayList<>();
        expectedList.add(listOfAirlinePlanes.get(4));
        assertEquals(expectedList, airlineService.getPlaneById(6));
        assertNotEquals(expectedList, airlineService.getPlaneById(7));
    }

    @Test
    public void testGetPlaneFromPassengerCapacityRange() {
        ArrayList<Plane> expectedList = new ArrayList<>();
        expectedList.add(listOfAirlinePlanes.get(2));
        expectedList.add(listOfAirlinePlanes.get(4));
        assertEquals(expectedList, airlineService.getPlaneFromPassengerCapacityRange(50, 80));
        assertNotEquals(expectedList, airlineService.getPlaneFromPassengerCapacityRange(50, 60));
    }

    @Test
    public void testFindPlaneWithMaxSpeed() {
        ArrayList<Plane> expectedList = new ArrayList<>();
        expectedList.add(listOfAirlinePlanes.get(4));
        expectedList.add(listOfAirlinePlanes.get(6));
        assertEquals(expectedList, airlineService.findPlaneWithMaxSpeed());
        expectedList.add(listOfAirlinePlanes.get(1));
        assertNotEquals(expectedList, airlineService.findPlaneWithMaxSpeed());
    }

    @Test
    public void testSortByFlightDistance() {
        ArrayList<Plane> expectedList = new ArrayList<>();
        expectedList.add(listOfAirlinePlanes.get(0));
        expectedList.add(listOfAirlinePlanes.get(5));
        expectedList.add(listOfAirlinePlanes.get(7));
        expectedList.add(listOfAirlinePlanes.get(6));
        expectedList.add(listOfAirlinePlanes.get(1));
        expectedList.add(listOfAirlinePlanes.get(3));
        expectedList.add(listOfAirlinePlanes.get(4));
        expectedList.add(listOfAirlinePlanes.get(8));
        expectedList.add(listOfAirlinePlanes.get(9));
        expectedList.add(listOfAirlinePlanes.get(2));
        assertEquals(expectedList, airlineService.sortByFlightDistance());
    }

    @Test
    public void testSortByFlightDistanceAndTypeOfPlane() {
        ArrayList<Plane> expectedList = new ArrayList<>();
        expectedList.add(listOfAirlinePlanes.get(0));
        expectedList.add(listOfAirlinePlanes.get(7));
        expectedList.add(listOfAirlinePlanes.get(5));
        expectedList.add(listOfAirlinePlanes.get(6));
        expectedList.add(listOfAirlinePlanes.get(8));
        expectedList.add(listOfAirlinePlanes.get(4));
        expectedList.add(listOfAirlinePlanes.get(1));
        expectedList.add(listOfAirlinePlanes.get(3));
        expectedList.add(listOfAirlinePlanes.get(9));
        expectedList.add(listOfAirlinePlanes.get(2));
        assertEquals(expectedList, airlineService.sortByFlightDistanceAndTypeOfPlane());
    }

    @Test
    public void testSumAllTakeoffWeight() {
        assertEquals(38385.0, airlineService.sumAllTakeoffWeight(), 0.000001);
    }

    @Test
    public void testSumAllPassengerCapacity() {
        assertEquals(665, airlineService.sumAllPassengerCapacity());
    }
}
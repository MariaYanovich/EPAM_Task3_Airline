package by.training.task3.airline.specification.impl;

import by.training.task3.airline.entity.PassengerPlane;
import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.entity.TransportPlane;
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

public class FindPlaneWithMaxSpeedTest {
    private ArrayList<Plane> listOfPlanes = new ArrayList<>();

    private FindPlaneWithMaxSpeed findPlaneWithMaxSpeed = new FindPlaneWithMaxSpeed();

    @Before
    public void initializeExpectedArrayListOfPlanes() {
        listOfPlanes.add(new PassengerPlane(1, PASSENGER, 100, 3400, 900, 2000, 5, ECONOMY));
        listOfPlanes.add(new TransportPlane(2, TRANSPORT, 2, 5000, 950, 2500, 3.6, MILITARY));
        listOfPlanes.add(new PassengerPlane(3, PASSENGER, 80, 3470, 970, 2600, 5, BUSINESS));
        listOfPlanes.add(new TransportPlane(4, TRANSPORT, 4, 4000, 950, 2500, 5.9, CIVILIAN));
    }

    @Test
    public void specified() {
        ArrayList<Plane> expectedList = new ArrayList<>();
        expectedList.add(listOfPlanes.get(2));
        assertEquals(expectedList, findPlaneWithMaxSpeed.specified(listOfPlanes));
    }
}
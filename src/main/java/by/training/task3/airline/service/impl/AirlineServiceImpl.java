package by.training.task3.airline.service.impl;

import by.training.task3.airline.comparator.PlaneComparatorByPracticalFlightDistance;
import by.training.task3.airline.comparator.PlaneComparatorByTypeOfPlane;
import by.training.task3.airline.entity.Plane;

import by.training.task3.airline.repository.AirlineRepository;
import by.training.task3.airline.repository.impl.AirlineRepositoryImpl;
import by.training.task3.airline.service.AirlineService;


import java.util.ArrayList;
import java.util.Comparator;

public class AirlineServiceImpl implements AirlineService {

    private AirlineRepository repository = new AirlineRepositoryImpl();

    public void addPlane(Plane plane) {
        repository.addPlane(plane);
    }

    public void removePlane(Plane plane) {
        repository.removePlane(plane);
    }

    public void updatePlane(Plane oldPlane, Plane newPlane) {
        repository.updatePlane(oldPlane, newPlane);
    }

    public boolean searchPlane(Plane plane) {
        return repository.searchPlane(plane);
    }

    public ArrayList<Plane> getAllPlanes() {
        return repository.getAllPlanes();
    }

    public ArrayList<Plane> getPlaneFromPassengerCapacityRange(int startOfRange, int endOfRange) {
        ArrayList<Plane> listToReturn = new ArrayList<>();
        for (Plane plane : getAllPlanes()) {
            if (plane.getPassengerCapacity() >= startOfRange
                    && plane.getPassengerCapacity() <= endOfRange) {
                listToReturn.add(plane);
            }
        }
        return listToReturn;
    }

    public Plane findPlaneWithMaxSpeed() {
        double maxSpeed = findMax(getAllPlanes());
        Plane planeToReturn = null;

        for (Plane plane : getAllPlanes()) {
            if (plane.getMaximumSpeed() == maxSpeed) {
                planeToReturn = plane;
            }
        }
        return planeToReturn;
    }

    private double findMax(ArrayList<Plane> list) {
        double maxSpeed = Double.MIN_VALUE;
        for (Plane plane : list) {
            if (plane.getMaximumSpeed() > maxSpeed) {
                maxSpeed = plane.getMaximumSpeed();
            }
        }
        return maxSpeed;
    }

    public double sumAllMaximumTakeOffWeight() {
        double sumToReturn = 0;
        for (Plane plane : getAllPlanes()) {
            sumToReturn += plane.getMaximumTakeoffWeight();
        }
        return sumToReturn;
    }

    public int sumAllPassengerCapacity() {
        int sumToReturn = 0;
        for (Plane plane : getAllPlanes()) {
            sumToReturn += plane.getPassengerCapacity();
        }
        return sumToReturn;
    }

    public ArrayList<Plane> sortByPracticalFlightDistance() {
        PlaneComparatorByPracticalFlightDistance planeComparator
                = new PlaneComparatorByPracticalFlightDistance();
        ArrayList<Plane> listToReturn = new ArrayList<>(getAllPlanes());
        listToReturn.sort(planeComparator);
        return listToReturn;
    }

    public ArrayList<Plane> sortByPracticalFlightDistanceAndTypeOfPlane() {
        Comparator<Plane> planeComparator
                = new PlaneComparatorByPracticalFlightDistance().thenComparing(
                new PlaneComparatorByTypeOfPlane());
        ArrayList<Plane> listToReturn = new ArrayList<>(getAllPlanes());
        listToReturn.sort(planeComparator);
        return listToReturn;
    }

}

package by.training.task3.airline.entity;

import by.training.task3.airline.enums.PlaneTypes;

import java.util.Objects;

public abstract class Plane {
    private static final int DEFAULT_ID = 0;
    private static final int DEFAULT_PASSENGER_CAPACITY = 2;
    private static final double DEFAULT_MAXIMUM_TAKE_OF_WEIGHT = 4700;
    private static final double DEFAULT_MAXIMUM_SPEED = 900;
    private static final double DEFAULT_PRACTICAL_FLIGHT_DISTANCE = 1015;
    private static final double DEFAULT_WEIGHT_OF_EMPTY_PLANE = 3395;

    private int id;
    private int passengerCapacity;
    private double maximumTakeoffWeight;
    private double maximumSpeed;
    private double practicalFlightDistance;
    private double weightOfEmptyPlane;
    protected PlaneTypes typeOfPlane;


    public Plane() {
        this.id = DEFAULT_ID;
        this.passengerCapacity = DEFAULT_PASSENGER_CAPACITY;
        this.maximumTakeoffWeight = DEFAULT_MAXIMUM_TAKE_OF_WEIGHT;
        this.maximumSpeed = DEFAULT_MAXIMUM_SPEED;
        this.practicalFlightDistance = DEFAULT_PRACTICAL_FLIGHT_DISTANCE;
        this.weightOfEmptyPlane = DEFAULT_WEIGHT_OF_EMPTY_PLANE;
    }

    public Plane(int id, PlaneTypes typeOfPlane, int passengerCapacity, double maximumTakeoffWeight,
                 double maximumSpeed, double practicalFlightDistance, double weightOfEmptyPlane) {
        this.id = id;
        this.typeOfPlane = typeOfPlane;
        this.passengerCapacity = passengerCapacity;
        this.maximumTakeoffWeight = maximumTakeoffWeight;
        this.maximumSpeed = maximumSpeed;
        this.practicalFlightDistance = practicalFlightDistance;
        this.weightOfEmptyPlane = weightOfEmptyPlane;

    }

    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public double getMaximumTakeoffWeight() {
        return maximumTakeoffWeight;
    }

    public void setMaximumTakeoffWeight(double maximumTakeoffWeight) {
        this.maximumTakeoffWeight = maximumTakeoffWeight;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public double getPracticalFlightDistance() {
        return practicalFlightDistance;
    }

    public void setPracticalFlightDistance(double practicalFlightDistance) {
        this.practicalFlightDistance = practicalFlightDistance;
    }

    public PlaneTypes getTypeOfPlane() {
        return typeOfPlane;
    }

    public void setTypeOfPlane(PlaneTypes typeOfPlane) {
        this.typeOfPlane = typeOfPlane;
    }

    public double getWeightOfEmptyPlane() {
        return weightOfEmptyPlane;
    }

    public void setWeightOfEmptyPlane(double weightOfEmptyPlane) {
        this.weightOfEmptyPlane = weightOfEmptyPlane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return getId() == plane.getId() &&
                getPassengerCapacity() == plane.getPassengerCapacity() &&
                Double.compare(plane.getMaximumTakeoffWeight(), getMaximumTakeoffWeight()) == 0 &&
                Double.compare(plane.getMaximumSpeed(), getMaximumSpeed()) == 0 &&
                Double.compare(plane.getPracticalFlightDistance(), getPracticalFlightDistance()) == 0 &&
                Double.compare(plane.getWeightOfEmptyPlane(), getWeightOfEmptyPlane()) == 0 &&
                getTypeOfPlane() == plane.getTypeOfPlane();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassengerCapacity(),
                getMaximumTakeoffWeight(), getMaximumSpeed(),
                getPracticalFlightDistance(), getWeightOfEmptyPlane(),
                getTypeOfPlane());
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", passengerCapacity=" + passengerCapacity +
                ", maximumTakeoffWeight=" + maximumTakeoffWeight +
                ", maximumSpeed=" + maximumSpeed +
                ", practicalFlightDistance=" + practicalFlightDistance +
                ", weightOfEmptyPlane=" + weightOfEmptyPlane +
                ", typeOfPlane=" + typeOfPlane;
    }
}

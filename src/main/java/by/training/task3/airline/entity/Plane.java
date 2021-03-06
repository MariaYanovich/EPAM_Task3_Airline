package by.training.task3.airline.entity;

import by.training.task3.airline.enums.PlaneType;

import java.util.Objects;

public abstract class Plane {

    protected int id;
    protected int passengerCapacity;
    protected double takeoffWeight;
    protected double speed;
    protected double flightDistance;
    protected PlaneType typeOfPlane;

    public Plane() {
    }

    public Plane(int id, PlaneType typeOfPlane, int passengerCapacity, double takeoffWeight,
                 double speed, double flightDistance) {
        this.id = id;
        this.typeOfPlane = typeOfPlane;
        this.passengerCapacity = passengerCapacity;
        this.takeoffWeight = takeoffWeight;
        this.speed = speed;
        this.flightDistance = flightDistance;

    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getTakeoffWeight() {
        return takeoffWeight;
    }

    public void setTakeoffWeight(double takeoffWeight) {
        this.takeoffWeight = takeoffWeight;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public double getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(double flightDistance) {
        this.flightDistance = flightDistance;
    }

    public PlaneType getTypeOfPlane() {
        return typeOfPlane;
    }

    public void setTypeOfPlane(PlaneType typeOfPlane) {
        this.typeOfPlane = typeOfPlane;
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
                Double.compare(plane.getTakeoffWeight(), getTakeoffWeight()) == 0 &&
                Double.compare(plane.getSpeed(), getSpeed()) == 0 &&
                Double.compare(plane.getFlightDistance(), getFlightDistance()) == 0 &&
                getTypeOfPlane() == plane.getTypeOfPlane();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassengerCapacity(),
                getTakeoffWeight(), getSpeed(),
                getFlightDistance(), getTypeOfPlane());
    }

    @Override
    public String toString() {
        return "PlaneID-" + id +
                ": typeOfPlane=" + typeOfPlane +
                ", passengerCapacity=" + passengerCapacity +
                ", takeoffWeight=" + takeoffWeight +
                ", speed=" + speed +
                ", flightDistance=" + flightDistance;
    }
}

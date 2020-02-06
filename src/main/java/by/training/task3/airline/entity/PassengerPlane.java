package by.training.task3.airline.entity;

import by.training.task3.airline.enums.PassengerPlaneTypes;
import by.training.task3.airline.enums.PlaneTypes;

import java.util.Objects;

public class PassengerPlane extends Plane {


    private int numberOfStewards;
    private PassengerPlaneTypes typeOfPassengerPlane;

    public PassengerPlane() {
        super.typeOfPlane = PlaneTypes.PASSENGER;
    }

    public PassengerPlane(int id, PlaneTypes typeOfPlane,
                          int passengerCapacity, double takeoffWeight,
                          double speed, double flightDistance,
                          int numberOfStewards, PassengerPlaneTypes typeOfPassengerPlane) {
        super(id, typeOfPlane, passengerCapacity, takeoffWeight,
                speed, flightDistance);
        this.numberOfStewards = numberOfStewards;
        this.typeOfPassengerPlane = typeOfPassengerPlane;
    }

    public PassengerPlaneTypes getTypeOfPassengerPlane() {
        return typeOfPassengerPlane;
    }

    public void setTypeOfPassengerPlane(PassengerPlaneTypes typeOfPassengerPlane) {
        this.typeOfPassengerPlane = typeOfPassengerPlane;
    }

    public int getNumberOfStewards() {
        return numberOfStewards;
    }

    public void setNumberOfStewards(int numberOfStewards) {
        this.numberOfStewards = numberOfStewards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        PassengerPlane that = (PassengerPlane) o;
        return getNumberOfStewards() == that.getNumberOfStewards() &&
                getTypeOfPassengerPlane() == that.getTypeOfPassengerPlane();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumberOfStewards(), getTypeOfPassengerPlane());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfStewards=" + numberOfStewards +
                ", typeOfPassengerPlane=" + typeOfPassengerPlane;
    }
}

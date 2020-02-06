package by.training.task3.airline.entity;

import by.training.task3.airline.enums.PlaneType;
import by.training.task3.airline.enums.TransportPlaneType;

import java.util.Objects;

public class TransportPlane extends Plane {

    private double volumeOfContainer;
    private TransportPlaneType typeOfTransportPlane;

    public TransportPlane() {
        super.typeOfPlane = PlaneType.TRANSPORT;
    }


    public TransportPlane(int id, PlaneType typeOfPlane, int passengerCapacity,
                          double takeoffWeight, double speed,
                          double flightDistance, double volumeOfContainer,
                          TransportPlaneType typeOfTransportPlane) {
        super(id, typeOfPlane, passengerCapacity,
                takeoffWeight, speed, flightDistance);
        this.volumeOfContainer = volumeOfContainer;
        this.typeOfTransportPlane = typeOfTransportPlane;
    }

    public TransportPlaneType getTypeOfTransportPlane() {
        return typeOfTransportPlane;
    }

    public void setTypeOfTransportPlane(TransportPlaneType typeOfTransportPlane) {
        this.typeOfTransportPlane = typeOfTransportPlane;
    }

    public double getVolumeOfContainer() {
        return volumeOfContainer;
    }

    public void setVolumeOfContainer(double volumeOfContainer) {
        this.volumeOfContainer = volumeOfContainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportPlane)) return false;
        if (!super.equals(o)) return false;
        TransportPlane that = (TransportPlane) o;
        return Double.compare(that.getVolumeOfContainer(), getVolumeOfContainer()) == 0
                && getTypeOfTransportPlane() == that.getTypeOfTransportPlane();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getVolumeOfContainer(), getTypeOfTransportPlane());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", volumeOfAirContainer=" + volumeOfContainer +
                ", typeOfTransportPlane=" + typeOfTransportPlane;
    }

}

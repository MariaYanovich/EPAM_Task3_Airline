package by.training.task3.airline.entity;

import by.training.task3.airline.enums.PlaneTypes;
import by.training.task3.airline.enums.TransportPlaneTypes;

import java.util.Objects;

public class TransportPlane extends Plane {

    private static final double DEFAULT_VOLUME_OF_CONTAINER = 3.4;

    private double volumeOfContainer;
    private TransportPlaneTypes typeOfTransportPlane;

    public TransportPlane() {
        super();
        super.typeOfPlane = PlaneTypes.TRANSPORT;
        this.volumeOfContainer = DEFAULT_VOLUME_OF_CONTAINER;
        this.typeOfTransportPlane = TransportPlaneTypes.CARGO;
    }


    public TransportPlane(int id, PlaneTypes typeOfPlane, int passengerCapacity,
                          double takeoffWeight, double speed,
                          double flightDistance, double volumeOfContainer,
                          TransportPlaneTypes typeOfTransportPlane) {
        super(id, typeOfPlane, passengerCapacity,
                takeoffWeight, speed, flightDistance);
        this.volumeOfContainer = volumeOfContainer;
        this.typeOfTransportPlane = typeOfTransportPlane;
    }

    public TransportPlaneTypes getTypeOfTransportPlane() {
        return typeOfTransportPlane;
    }

    public void setTypeOfTransportPlane(TransportPlaneTypes typeOfTransportPlane) {
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

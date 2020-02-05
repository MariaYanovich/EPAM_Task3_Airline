package by.training.task3.airline.entity;


import by.training.task3.airline.enums.PlaneTypes;
import by.training.task3.airline.enums.TransportPlaneTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class TransportPlane extends Plane {
    private static final double DEFAULT_VOLUME_OF_AIR_CONTAINER = 3.4;
    private double volumeOfAirContainer;
    private TransportPlaneTypes typeOfTransportPlane;

    public TransportPlane() {
        super();
        super.typeOfPlane = PlaneTypes.TRANSPORT_PLANE;
        this.volumeOfAirContainer = DEFAULT_VOLUME_OF_AIR_CONTAINER;
        this.typeOfTransportPlane = TransportPlaneTypes.EXCEPTIONALLY_TRANSPORT;
    }


    public TransportPlane(int id, PlaneTypes typeOfPlane, int passengerCapacity,
                          double maximumTakeoffWeight, double maximumSpeed,
                          double practicalFlightDistance,
                          double weightOfEmptyPlane, double volumeOfAirContainer,
                          TransportPlaneTypes typeOfTransportPlane) {
        super(id, typeOfPlane, passengerCapacity, maximumTakeoffWeight,
                maximumSpeed, practicalFlightDistance, weightOfEmptyPlane);
        this.volumeOfAirContainer = volumeOfAirContainer;
        this.typeOfTransportPlane = typeOfTransportPlane;
    }

    public TransportPlaneTypes getTypeOfTransportPlane() {
        return typeOfTransportPlane;
    }

    public void setTypeOfTransportPlane(TransportPlaneTypes typeOfTransportPlane) {
        this.typeOfTransportPlane = typeOfTransportPlane;
    }

    public double getVolumeOfAirContainer() {
        return volumeOfAirContainer;
    }

    public void setVolumeOfAirContainer(double volumeOfAirContainer) {
        this.volumeOfAirContainer = volumeOfAirContainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransportPlane)) return false;
        if (!super.equals(o)) return false;
        TransportPlane that = (TransportPlane) o;
        return Double.compare(that.getVolumeOfAirContainer(), getVolumeOfAirContainer()) == 0 &&
                getTypeOfTransportPlane() == that.getTypeOfTransportPlane();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getVolumeOfAirContainer(), getTypeOfTransportPlane());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", volumeOfAirContainer=" + volumeOfAirContainer +
                ", typeOfTransportPlane=" + typeOfTransportPlane +
                '}';
    }

}

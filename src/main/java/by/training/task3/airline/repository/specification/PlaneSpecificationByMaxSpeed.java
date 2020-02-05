package by.training.task3.airline.repository.specification;

import by.training.task3.airline.entity.Plane;

public class PlaneSpecificationByMaxSpeed implements PlaneSpecification {
    private double maxSpeed;
    private double planeSpeed;

    public PlaneSpecificationByMaxSpeed(double maxSpeed, Plane plane) {
        this.maxSpeed = maxSpeed;
        this.planeSpeed = plane.getMaximumSpeed();
    }

    @Override
    public boolean specified(Plane plane) {
        return maxSpeed > plane.getMaximumSpeed();
    }
}

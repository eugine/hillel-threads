package ua.ithillel.patterns.structural.decorator.vehicle;

abstract class Vehicle {
    public abstract String getDescription();
    public abstract double getCost();
}

class Car extends Vehicle {
    public String getDescription() {
        return "Car";
    }

    public double getCost() {
        return 15_000.0;
    }
}

public abstract class VehicleDecorator extends Vehicle {
    protected Vehicle vehicle;

    public VehicleDecorator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract String getDescription();
    public abstract double getCost();
}

class GPSNavigator extends VehicleDecorator {
    public GPSNavigator(Vehicle vehicle) {
        super(vehicle);
    }

    public String getDescription() {
        return vehicle.getDescription() + ", GPS Navigator";
    }

    public double getCost() {
        return vehicle.getCost() + 200.0;
    }
}

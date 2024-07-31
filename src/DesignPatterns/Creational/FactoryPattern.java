package DesignPatterns.Creational;

public class FactoryPattern {
    public static void main(String[] args) {
        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        Vehicle twoWheeler = new Client(twoWheelerFactory).getVehicle();
    }
}

interface Vehicle {

}

class TwoWheeler implements Vehicle {

}

class ThreeWheeler implements Vehicle {

}

interface VehicleFactory {
    Vehicle createVehicle();
}

class TwoWheelerFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}

class ThreeWheelerFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new ThreeWheeler();
    }
}

class Client {
    private Vehicle vehicle;

    Client(VehicleFactory vehicleFactory) {
        this.vehicle = vehicleFactory.createVehicle();
    }

    Vehicle getVehicle() {
        return vehicle;
    }
}
package SOLID;

public class Liskov {
    public static void main(String[] args) {

    }
}

class Vehicle {

    int wheels;

    public int numberOfWheels() {
        return wheels;
    }

    public boolean hasEngine() {
        return true;
    }
}

class Bike extends Vehicle {
    public Bike() {
        super();
        this.wheels = 2;
    }

    @Override
    public boolean hasEngine() {
        return false;
    }

}

class Cycle extends Vehicle {
    public Cycle() {
        super();
        this.wheels = 2;
    }

    @Override
    public boolean hasEngine() {
        return false;
    }
}

interface VehicleInterface {
    int numberOfWheels();
}

interface EngineVehicle extends VehicleInterface {
    void hasEngine();
}

interface NonEngineVehicle extends VehicleInterface {
}

class MotorBike implements EngineVehicle {
    @Override
    public int numberOfWheels() {
        return 2;
    }

    @Override
    public void hasEngine() {
        System.out.println("Motorbike has an engine");
    }
}

class Tricycle implements NonEngineVehicle {
    @Override
    public int numberOfWheels() {
        return 3;
    }
}
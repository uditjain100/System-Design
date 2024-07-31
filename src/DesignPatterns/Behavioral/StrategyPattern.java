package DesignPatterns.Behavioral;

public class StrategyPattern {
    public static void main(String[] args) {

    }
}

class Vehicle {
    // old Methods
    // ...
    // new method added
    DrivingFunctionality drivingFunctionality;

    // drivingFunctionality can be of type roadways or airways
    Vehicle(DrivingFunctionality drivingFunctionality) {
        this.drivingFunctionality = drivingFunctionality;
    }
}

class Car extends Vehicle {
    // old Methods
    // ...
    // new method added

    Car(DrivingFunctionality drivingFunctionality) {
        super(drivingFunctionality);
    }

    void drive() {
        this.drivingFunctionality.drive();
    }
}

class Airplane extends Vehicle {
    // old Methods
    // ...
    // new method added
    Airplane(DrivingFunctionality drivingFunctionality) {
        super(drivingFunctionality);
    }

    void drive() {
        this.drivingFunctionality.drive();
    }
}

class Helicopter extends Vehicle {
    // old Methods
    // ...
    // new method added
    Helicopter(DrivingFunctionality drivingFunctionality) {
        super(drivingFunctionality);
    }

    void drive() {
        this.drivingFunctionality.drive();
    }
}

interface DrivingFunctionality {
    void drive();
}

class RoadWays implements DrivingFunctionality {
    @Override
    public void drive() {
        System.out.println("drive");
    }
}

class Airways implements DrivingFunctionality {
    @Override
    public void drive() {
        System.out.println("fly");
    }
}
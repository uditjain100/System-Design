package DesignPatterns.Creational;

public class AbstractFactory {
    public static void main(String[] args) {

        CarFactory northCarFactory = new NorthCarFactory();
        Client client = new Client(northCarFactory);
        Car northCar = client.getCar();
        CarSpecs northCarSpecs = client.getCarSpecs();
    }
}

interface Car {

}

class Sedan implements Car {
}

class HatchBlack implements Car {
}

interface CarSpecs {

}

class NorthCar implements CarSpecs {
}

class SouthCar implements CarSpecs {
}

interface CarFactory {
    Car createCar();

    CarSpecs createCarSpecs();
}

class NorthCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Sedan();
    }

    @Override
    public CarSpecs createCarSpecs() {
        return new NorthCar();
    }
}

class SouthCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new HatchBlack();
    }

    @Override
    public CarSpecs createCarSpecs() {
        return new SouthCar();
    }
}

class Client {
    Car car;
    CarSpecs carSpecs;

    Client(CarFactory carFactory) {
        this.car = carFactory.createCar();
        this.carSpecs = carFactory.createCarSpecs();
    }

    public Car getCar() {
        return this.car;
    }

    public CarSpecs getCarSpecs() {
        return this.carSpecs;
    }
}
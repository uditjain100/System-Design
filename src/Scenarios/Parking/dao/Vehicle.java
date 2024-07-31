package Scenarios.Parking.dao;

import Scenarios.Parking.enums.VehicleType;

public final class Vehicle {
    private final int vehicleNo;
    private final String name;
    private final VehicleType vehicleType;

    public Vehicle(int vehicleNo, String name, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.name = new String(name);
        this.vehicleType = vehicleType;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public String getName() {
        return new String(name);
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNo=" + vehicleNo +
                ", name='" + name + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}

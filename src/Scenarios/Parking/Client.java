package Scenarios.Parking;

import Scenarios.Parking.dao.Ticket;
import Scenarios.Parking.dao.Vehicle;
import Scenarios.Parking.enums.VehicleType;

public class Client {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance("ABC", "1233", 10);

        Vehicle vehicle = new Vehicle(5566, "Sedan", VehicleType.THREE_WHEELER_LARGE);
        Ticket ticket = parkingLot.generateTicket(vehicle);

        System.out.println(parkingLot.scanAndPay(ticket));
    }
}

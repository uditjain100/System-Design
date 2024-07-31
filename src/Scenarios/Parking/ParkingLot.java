package Scenarios.Parking;

import java.util.*;

import Scenarios.Parking.dao.*;
import Scenarios.Parking.enums.SlotType;
import Scenarios.Parking.utility.Utilities;

public class ParkingLot {

    public static ParkingLot parkingLot;
    private final String parkingLotId;
    private final String address;
    public static int floorsCount;

    private List<ParkingFloor> floors;

    private ParkingLot(String parkingLotId, String address, int floorsCount) {
        this.parkingLotId = parkingLotId;
        this.address = address;
        ParkingLot.floorsCount = floorsCount;

        this.floors = new ArrayList<ParkingFloor>();
        for (int i = 0; i < floorsCount; i++)
            floors.add(new ParkingFloor(i, 10, 10, 10));
    }

    public static ParkingLot getInstance(String parkingLotId, String address, int floorsCount) {
        if (parkingLot == null)
            parkingLot = new ParkingLot(parkingLotId, address, floorsCount);
        return parkingLot;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public String getAddress() {
        return address;
    }

    public void addFloor(int countSmallSlots, int countMediumSlots, int countLargeSlots) {
        ParkingLot.floorsCount++;
        this.floors.add(new ParkingFloor(this.floorsCount, countSmallSlots, countMediumSlots, countLargeSlots));
    }

    public void removeFloor() {
        this.floors.remove(ParkingLot.floorsCount - 1);
        ParkingLot.floorsCount--;
    }

    public ParkingFloor getFloor(int floorNumber) {
        return floors.get(floorNumber - 1);
    }

    public void printParkingStatus() {
        for (ParkingFloor floor : floors)
            System.out.println(floor.getSlots());
    }

    public Ticket generateTicket(Vehicle vehicle) {
        SlotType slotType = Utilities.vehicleSlotMapper.get(vehicle.getVehicleType());
        if (Utilities.availableSlots.get(slotType).size() == 0) {
            System.out.println("Slot is not available !!");
            return null;
        }

        String slotId = Utilities.availableSlots.get(slotType).pop();

        ParkingSlot parkingSlot = null;
        for (ParkingSlot slot : floors.get(slotId.charAt(0) - '0').getSlots()) {
            if (slot.getSlotId().equals(slotId)) {
                parkingSlot = slot;
                break;
            }
        }

        parkingSlot.setVehicle(vehicle);

        Ticket ticket = new Ticket(8598, slotType.getCostPerHour(), vehicle, parkingSlot, System.currentTimeMillis());
        return ticket;
    }

    public double scanAndPay(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        if (ticket == null) {
            System.out.println("Invalid ticket or ticket expired!!");
            return 0.0;
        }

        long duration = endTime - ticket.getStartTime() + (25000 * 60 * 6);
        double totalCost = Math.ceil((duration / (1000.0 * 60.0 * 60.0))) * ticket.getCost();

        ParkingSlot parkingSlot = ticket.getParkingSlot();
        parkingSlot.setIsAvailable(true);
        Utilities.availableSlots.get(parkingSlot.getSlotType()).push(parkingSlot.getSlotId());

        return totalCost;
    }
}

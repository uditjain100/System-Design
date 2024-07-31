package Scenarios.Parking.dao;

import Scenarios.Parking.enums.SlotType;

public class ParkingSlot {

    private final String SlotId;
    private final SlotType slotType;
    private final int floor;
    private boolean isAvailable;
    private Vehicle parkedVehicle;

    public ParkingSlot(String slotId, SlotType slotType, int floor) {
        this.SlotId = slotId;
        this.slotType = slotType;
        this.isAvailable = true;
        this.parkedVehicle = null;
        this.floor = floor;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
        if (isAvailable) {
            this.parkedVehicle = null;
        }
    }

    public void setVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
        this.isAvailable = false;
    }

    public String getSlotId() {
        return SlotId;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public int getFloor() {
        return floor;
    }
}

package Scenarios.Parking.dao;

import java.util.*;

import Scenarios.Parking.enums.SlotType;
import Scenarios.Parking.utility.Utilities;

public class ParkingFloor {

    private final int floorNumber;
    private int numberOfSlots;
    private int countSmallSlots;
    private int countMediumSlots;
    private int countLargeSlots;

    private List<ParkingSlot> slots;

    public ParkingFloor(int floorNumber, int countSmallSlots, int countMediumSlots,
            int countLargeSlots) {
        this.floorNumber = floorNumber;
        this.countSmallSlots = countSmallSlots;
        this.countMediumSlots = countMediumSlots;
        this.countLargeSlots = countLargeSlots;
        this.numberOfSlots = countLargeSlots + countSmallSlots + countMediumSlots;
        this.slots = new ArrayList<>();

        for (int i = 0; i < countSmallSlots; i++)
            slots.add(new ParkingSlot(Utilities.generateSlotId(floorNumber, i, SlotType.SMALL), SlotType.SMALL,
                    this.floorNumber));
        for (int i = 0; i < countMediumSlots; i++)
            slots.add(new ParkingSlot(Utilities.generateSlotId(floorNumber, i, SlotType.MEDIUM), SlotType.MEDIUM,
                    this.floorNumber));
        for (int i = 0; i < countLargeSlots; i++)
            slots.add(new ParkingSlot(Utilities.generateSlotId(floorNumber, i, SlotType.LARGE), SlotType.LARGE,
                    this.floorNumber));
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }

    public int getSlotCount() {
        return this.numberOfSlots;
    }

    public int getSmallSlotCount() {
        return this.countSmallSlots;
    }

    public int getMediumSlotCount() {
        return this.countMediumSlots;
    }

    public int getLargeSlotCount() {
        return this.countLargeSlots;
    }

    public List<ParkingSlot> getSlots() {
        return this.slots;
    }
}

package Scenarios.Parking.utility;

import java.util.*;

import Scenarios.Parking.enums.SlotType;
import Scenarios.Parking.enums.VehicleType;

public class Utilities {
    public static final Map<VehicleType, SlotType> vehicleSlotMapper = VehicleSlotMapper.getMap();
    public static final Map<SlotType, Stack<String>> availableSlots = AvailableSlotsGenerator.getAvailableSlots();

    public static final String generateSlotId(int floorNumber, int slotNumber, SlotType slotType) {
        return "" + floorNumber + "" + (slotType == SlotType.LARGE ? "L" : slotType == SlotType.MEDIUM ? "M" : "S")
                + slotNumber;
    }
}

package Scenarios.Parking.utility;

import java.util.*;

import Scenarios.Parking.ParkingLot;
import Scenarios.Parking.enums.SlotType;

public class AvailableSlotsGenerator {
    private static Map<SlotType, Stack<String>> map;

    private AvailableSlotsGenerator() {

    }

    public static Map<SlotType, Stack<String>> getAvailableSlots() {
        if (map == null) {
            map = new HashMap<>();

            map.put(SlotType.SMALL, new Stack<String>());
            map.put(SlotType.MEDIUM, new Stack<String>());
            map.put(SlotType.LARGE, new Stack<String>());

            // Add available slots
            for (int floor = 0; floor < ParkingLot.floorsCount; floor++) {
                for (int i = 0; i < 10; i++) {
                    map.get(SlotType.SMALL).push(Utilities.generateSlotId(floor, i, SlotType.SMALL));
                    map.get(SlotType.MEDIUM).push(Utilities.generateSlotId(floor, i, SlotType.MEDIUM));
                    map.get(SlotType.LARGE).push(Utilities.generateSlotId(floor, i, SlotType.LARGE));
                }
            }
        }
        return map;
    }
}

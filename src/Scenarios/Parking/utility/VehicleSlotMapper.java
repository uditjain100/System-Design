package Scenarios.Parking.utility;

import java.util.*;

import Scenarios.Parking.enums.SlotType;
import Scenarios.Parking.enums.VehicleType;

public class VehicleSlotMapper {
    private static Map<VehicleType, SlotType> map;

    private VehicleSlotMapper() {
    }

    public static Map<VehicleType, SlotType> getMap() {
        if (map == null) {
            map = new HashMap<>();

            map.put(VehicleType.TWO_WHEELER_SMALL, SlotType.SMALL);
            map.put(VehicleType.TWO_WHEELER_MEDIUM, SlotType.SMALL);
            map.put(VehicleType.TWO_WHEELER_LARGE, SlotType.SMALL);

            map.put(VehicleType.THREE_WHEELER_SMALL, SlotType.SMALL);
            map.put(VehicleType.THREE_WHEELER_MEDIUM, SlotType.MEDIUM);
            map.put(VehicleType.THREE_WHEELER_LARGE, SlotType.MEDIUM);

            map.put(VehicleType.FOUR_WHEELER_SMALL, SlotType.MEDIUM);
            map.put(VehicleType.FOUR_WHEELER_MEDIUM, SlotType.LARGE);
            map.put(VehicleType.FOUR_WHEELER_LARGE, SlotType.LARGE);
        }
        return map;
    }

}

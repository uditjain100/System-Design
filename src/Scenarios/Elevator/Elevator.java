package Scenarios.Elevator;

import java.util.List;

import Scenarios.Elevator.dao.*;
import Scenarios.Elevator.utility.Utilities;

public class Elevator {

    private static Elevator elevator;

    static List<ElevatorCar> elevatorCars;
    static List<Floor> floors;

    private Elevator() {
        for (int i = 0; i < Utilities.ELEVATOR_COUNT; i++)
            elevatorCars.add(new ElevatorCar(i, Utilities.MIN_FLOOR, Utilities.MAX_FLOOR));
        for (int i = 0; i < Utilities.FLOORS_COUNT; i++)
            floors.add(new Floor(i));
    }

    public static void startElevator() {
        if (elevator == null)
            Elevator.elevator = new Elevator();
        else {
            // Dispatch elevator to the nearest floor
            callElevator();
        }
    }

    public static void stopElevator() {
        for (int i = 0; i < Utilities.ELEVATOR_COUNT; i++)
            elevatorCars.set(i, null);
        for (int i = 0; i < Utilities.FLOORS_COUNT; i++)
            floors.set(i, null);

        Elevator.elevator = null;
        System.gc();
    }

    private static void callElevator() {

    }
}

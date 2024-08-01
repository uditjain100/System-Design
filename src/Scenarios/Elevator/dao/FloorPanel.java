package Scenarios.Elevator.dao;

import java.util.*;

import Scenarios.Elevator.enums.State;
import Scenarios.Elevator.utility.Utilities;

public class FloorPanel implements ButtonPanel {

    final int floorNo;
    boolean isMovingUpButtonPressed;
    boolean isMovingDownButtonPressed;

    public static Map<Integer, Boolean> floorStatus = new HashMap<Integer, Boolean>();

    public FloorPanel(int floorNo) {
        this.floorNo = floorNo;
        this.isMovingDownButtonPressed = false;
        this.isMovingUpButtonPressed = false;
    }

    public void upButtonPressed() {
        this.isMovingUpButtonPressed = true;

        Utilities.getElevatorIdeally(floorNo, State.MOVING_UP);
        this.isMovingUpButtonPressed = false;
    }

    public void downButtonPressed() {
        this.isMovingDownButtonPressed = true;

        Utilities.getElevatorIdeally(floorNo, State.MOVING_DOWN);
        this.isMovingDownButtonPressed = false;
    }

    @Override
    public boolean sendInstructionToDispatcher(int currentFloor, int destFloor, boolean isMoving) {
        return true;
    }
}

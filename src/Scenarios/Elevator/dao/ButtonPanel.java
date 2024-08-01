package Scenarios.Elevator.dao;

public interface ButtonPanel {
    boolean sendInstructionToDispatcher(int currentFloor, int destFloor, boolean isMovingUp);
}

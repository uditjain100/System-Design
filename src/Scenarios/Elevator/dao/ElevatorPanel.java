package Scenarios.Elevator.dao;

public class ElevatorPanel implements ButtonPanel {

    public ElevatorPanel() {

    }

    @Override
    public boolean sendInstructionToDispatcher(int currentFloor, int destFloor, boolean isMovingUp) {
        return true;
    }
}

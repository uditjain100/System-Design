package Scenarios.Elevator.dao;

public class ElevatorCar {

    private int elevatorCarId;
    ButtonPanel panel;
    Door door;

    boolean isMoving;
    boolean isMovingDown;

    int currentFloor;

    int startFloor;
    int endFloor;

    public ElevatorCar(int id, int startFloor, int endFloor) {
        this.elevatorCarId = id;
        this.panel = new ElevatorPanel();
        this.door = new Door();

        this.startFloor = startFloor;
        this.endFloor = endFloor;

        this.isMoving = false;
        this.isMovingDown = false;
        this.currentFloor = startFloor;
    }

    public int getElevatorCarId() {
        return this.elevatorCarId;
    }

    // Called by dispatcher
    public void moveToFloor(int floor) {
        this.isMoving = true;
        if (floor < this.currentFloor)
            this.isMovingDown = true;
        else
            this.isMovingDown = false;

        this.currentFloor = floor;
    }
}

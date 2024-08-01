package Scenarios.Elevator.dao;

public class Door {

    boolean isOpen;

    public void closeTheDoor() {
        this.isOpen = false;
    }

    public void openTheDoor() {
        this.isOpen = true;
    }
}

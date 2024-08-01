package Scenarios.Elevator.dao;

public class Floor {
    private final int floor;
    private FloorPanel panel;

    public Floor(int floor) {
        this.floor = floor;
        this.panel = new FloorPanel(floor);
    }

    public FloorPanel getPanel() {
        return panel;
    }

    public int getFloor() {
        return this.floor;
    }

}

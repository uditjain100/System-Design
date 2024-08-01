package Scenarios.Elevator;

import java.util.List;

import Scenarios.Elevator.dao.Floor;

public class Client {
    public static void main(String[] args) {
        Elevator.startElevator();
        List<Floor> floors = Elevator.floors;
        floors.get(25).getPanel().upButtonPressed();

    }
}

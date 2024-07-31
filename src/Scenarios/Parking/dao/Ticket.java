package Scenarios.Parking.dao;

public class Ticket {
    private int ticketId;
    private int cost;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private long startTime;

    public Ticket(int ticketId, int cost, Vehicle vehicle, ParkingSlot parkingSlot, Long startTime) {
        this.cost = cost;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.ticketId = ticketId;
        this.startTime = startTime;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getCost() {
        return cost;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public long getStartTime() {
        return startTime;
    }
}

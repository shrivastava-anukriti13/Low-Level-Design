import Fare.FareCalculator;
import Fare.Ticket;
import Spot.ParkingManager;
import Spot.ParkingSpot;
import Vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkingLot {
    private final ParkingManager parkingManager;
    private final FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator) {
        this.parkingManager = parkingManager;
        this.fareCalculator = fareCalculator;
    }

    public Ticket enterVehicle(Vehicle vehicle){
        ParkingSpot spot = parkingManager.parkVehicle(vehicle);

        if(spot != null){
            Ticket ticket = new Ticket(generateTicketId(),vehicle, spot, LocalDateTime.now());
            return ticket;
        }else{
            return null;
        }
    }

    public void leaveVehicle(Ticket ticket) {
        if (ticket != null && ticket.getExitTime() == null) {  // Ensure the ticket is valid and the vehicle hasn't already left
            // Set exit time
            ticket.setExitTime(LocalDateTime.now());

            // Delegate unparking logic to ParkingManager
            parkingManager.unparkVehicle(ticket.getVehicle());

            // Calculate the fare
            BigDecimal fare = fareCalculator.calculateFare(ticket);
        } else {
            // Invalid ticket or vehicle already exited.
        }
    }

    private String generateTicketId() {
        return "TICKET-" + System.currentTimeMillis();
    }
}

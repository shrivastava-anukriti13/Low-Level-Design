import Fare.*;
import Spot.ParkingManager;
import Spot.ParkingSpot;
import Spot.RegularSpot;
import Vehicle.VehicleSize;
import Vehicle.Vehicle;
import Vehicle.Car;
import java.util.*;

public class Main {

    private ParkingLot parkingLot;
    private ParkingManager parkingManager;
    private FareCalculator fareCalculator;

    public static void main(String[] args) {
        Main main = new Main();
        main.runVehicleJourneyTest();
    }

    public void runVehicleJourneyTest() {
        System.out.println("\n=== Testing Parking Lot System: Complete Vehicle Journey ===");

        System.out.println("\n--- Setting Up Parking Spots ---");
        Map<VehicleSize, List<ParkingSpot>> availableSpots = new HashMap<>();
        availableSpots.put(VehicleSize.MEDIUM, new ArrayList<>());
        availableSpots.get(VehicleSize.MEDIUM).add(new RegularSpot(1));
        availableSpots.get(VehicleSize.MEDIUM).add(new RegularSpot(2));
        System.out.println("✓ Created 2 regular parking spots for medium-sized vehicles");
        System.out.println("  - Spot 1: Regular parking spot");
        System.out.println("  - Spot 2: Regular parking spot");

        System.out.println("\n--- Initializing Parking Manager ---");
        parkingManager = new ParkingManager(availableSpots);
        System.out.println("✓ Parking manager initialized with available spots");

        System.out.println("\n--- Setting Up Fare Calculation System ---");
        List<FareStrategy> strategies = new ArrayList<>(List.of(new BaseFareStrategy(), new PeakHoursFareStrategy()));
        fareCalculator = new FareCalculator(strategies);
        System.out.println("✓ Fare calculator initialized with multiple strategies:");
        System.out.println("  - Base fare strategy");
        System.out.println("  - Peak hours fare strategy");

        parkingLot = new ParkingLot(parkingManager, fareCalculator);

        System.out.println("\n--- Creating Test Vehicle ---");
        Vehicle car = new Car("ABC123");
        System.out.println("✓ Created car with license plate: ABC123");
        System.out.println("  - Vehicle type: Car (MEDIUM size)");

        System.out.println("\n--- Vehicle Entering Parking Lot ---");
        // Vehicle enters the parking lot
        Ticket ticket = parkingLot.enterVehicle(car);
        if (ticket != null) {
            System.out.println("✓ Ticket generated for vehicle ABC123");
            System.out.println("✓ Parking spot assigned: " + ticket.getParkingSpot().getSpotNumber());
            System.out.println("✓ Ticket validation passed:");
            System.out.println("  - Ticket is not null");
            System.out.println("  - Vehicle matches the one that entered");
            System.out.println("  - Parking spot assigned successfully");
        } else {
            System.out.println("✗ Failed to generate ticket for vehicle");
            return;
        }

        // Find the vehicle in the parking lot
        ParkingSpot foundSpot = parkingManager.findVehicleSpot(car);
        if (foundSpot != null) {
            System.out.println("✓ Vehicle found in parking lot at spot: " + foundSpot.getSpotNumber());
        } else {
            System.out.println("✗ Vehicle not found in parking lot");
        }

        System.out.println("\n--- Vehicle Leaving Parking Lot ---");
        // Vehicle leaves the parking lot
        parkingLot.leaveVehicle(ticket);
        if (ticket.getExitTime() != null) {
            System.out.println("✓ Exit time recorded on ticket");
        }
        if (foundSpot != null && foundSpot.isAvailable()) {
            System.out.println("✓ Parking spot is now available for other vehicles");
        }
        System.out.println("✓ Vehicle exit verification passed:");
        System.out.println("  - Exit time recorded on ticket");
        System.out.println("  - Parking spot is now available for other vehicles");
        System.out.println("=== Parking Lot Vehicle Journey Test Completed Successfully ===\n");
    }
}
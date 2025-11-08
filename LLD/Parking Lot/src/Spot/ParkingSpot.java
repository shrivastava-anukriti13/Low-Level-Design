package Spot;

import Vehicle.VehicleSize;
import Vehicle.Vehicle;

public interface ParkingSpot {
    int getSpotNumber();
    VehicleSize getSize();
    boolean isAvailable();
    void occupy(Vehicle vehicle);
    void vacate();
}

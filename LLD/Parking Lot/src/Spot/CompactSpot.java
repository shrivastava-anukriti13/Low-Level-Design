package Spot;

import Vehicle.Vehicle;
import Vehicle.VehicleSize;

public class CompactSpot implements ParkingSpot{
    private int spotNumber;
    private Vehicle vehicle;

    public CompactSpot(int spotNumber){
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    @Override
    public int getSpotNumber(){
        return this.spotNumber;
    }

    @Override
    public VehicleSize getSize(){
        return VehicleSize.SMALL;
    }

    @Override
    public boolean isAvailable(){
        return vehicle==null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if (isAvailable()) {
            this.vehicle = vehicle;
        } else {
            // Spot is already occupied
        }
    }

    @Override
    public void vacate() {
        this.vehicle = null;  // Make the spot available
    }
}

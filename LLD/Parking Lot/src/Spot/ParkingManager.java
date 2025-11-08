package Spot;

import Vehicle.Vehicle;
import Vehicle.VehicleSize;
import java.util.*;

public class ParkingManager {
    Map<VehicleSize,List<ParkingSpot>> availableSpots;
    Map<Vehicle,ParkingSpot> vehicleToSpotMap;

    public ParkingManager(Map<VehicleSize,List<ParkingSpot>> availableSpots){
        this.availableSpots = availableSpots;
        this.vehicleToSpotMap = new HashMap<>();
    }

    public ParkingSpot findSpotForVehicle(Vehicle vehicle){
        VehicleSize vehicleSize = vehicle.getSize();

        for(VehicleSize size: VehicleSize.values()){
            if(size.ordinal() >= vehicleSize.ordinal()){
                List<ParkingSpot> spots = availableSpots.get(size);
                for(ParkingSpot spot: spots){
                    if(spot.isAvailable()){
                        return spot;
                    }
                }
            }
        }

        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findSpotForVehicle(vehicle);
        if(spot != null){
            spot.occupy(vehicle);
            vehicleToSpotMap.put(vehicle,spot);
            availableSpots.get(spot.getSize()).remove(spot);
            return spot;
        }
        return null;
    }

    public void unparkVehicle(Vehicle vehicle){
        ParkingSpot spot = vehicleToSpotMap.get(vehicle);
        if(spot != null){
            spot.vacate();
            availableSpots.get(spot.getSize()).add(spot);
        }
    }

    public ParkingSpot findVehicleSpot(Vehicle vehicle) {
        return vehicleToSpotMap.get(vehicle);
    }
}

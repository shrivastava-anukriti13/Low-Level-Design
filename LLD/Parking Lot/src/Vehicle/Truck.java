package Vehicle;

public class Truck implements Vehicle{
    private String licencePlate;

    public Truck(String licenceNum){
        this.licencePlate = licenceNum;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.LARGE;
    }

    @Override
    public String getLicencePlate(){
        return this.licencePlate;
    }
}

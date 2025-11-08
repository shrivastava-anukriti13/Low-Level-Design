package Vehicle;

public class Motorcycle implements  Vehicle{
    private String licencePlate;

    public Motorcycle(String licenceNum){
        this.licencePlate = licenceNum;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.SMALL;
    }

    @Override
    public String getLicencePlate(){
        return this.licencePlate;
    }
}

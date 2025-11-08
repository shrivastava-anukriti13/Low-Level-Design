package Vehicle;

public class Car implements Vehicle{
    private String licencePlate;

    public Car(String licenceNum){
        this.licencePlate = licenceNum;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.MEDIUM;
    }

    @Override
    public String getLicencePlate(){
        return this.licencePlate;
    }
}

package Observer;
import Observable.WeatherStation;

public class PhoneDisplay implements Observer {
    private final WeatherStation station;

    public PhoneDisplay(WeatherStation station) {
        this.station = station;
        this.station.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Phone Display: Temperature updated to " + station.getTemperature() + "°C");
    }
}

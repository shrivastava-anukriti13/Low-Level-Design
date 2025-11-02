package Observer;
import Observable.WeatherStation;

public class TVDisplay implements Observer {
    private final WeatherStation station;

    public TVDisplay(WeatherStation station) {
        this.station = station;
        this.station.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("TV Display: The current weather temperature is " + station.getTemperature() + "°C.");
    }
}

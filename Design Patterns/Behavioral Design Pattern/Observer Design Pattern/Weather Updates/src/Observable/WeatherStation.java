package Observable;
import Observer.Observer;
import java.util.*;

public class WeatherStation implements Observable {
    private int temperature;
    private final List<Observer> observers = new ArrayList<>();

    public void setTemperature(int temp) {
        System.out.println("Weather station is updating temperature to " + temp + "°C.");
        this.temperature = temp;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
        System.out.println("Observer added: " + o.getClass().getSimpleName());
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        System.out.println("Observer removed: " + o.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers() {
        System.out.println("Notifying all observers...");
        for (Observer o : observers) {
            o.update();
        }
    }

    public int getTemperature() {
        return temperature;
    }
}

import Observer.*;
import Observable.*;

public class Main {
    public static void main(String[] args) {
        // Create the subject
        WeatherStation station = new WeatherStation();

        // Create and register the first observer
        PhoneDisplay display1 = new PhoneDisplay(station);

        // Create and register the second observer
        TVDisplay display2 = new TVDisplay(station);

        System.out.println("--- Setting temperature to 25°C ---");
        station.setTemperature(25);

        System.out.println("\n--- Setting temperature to 30°C ---");
        station.setTemperature(30);

        System.out.println("\n--- Removing the phone display ---");
        station.removeObserver(display1);

        System.out.println("\n--- Setting temperature to 28°C ---");
        station.setTemperature(28); // Only the TV display will be notified
    }
}
package logistics;

public class Road implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by Road");
    }
}
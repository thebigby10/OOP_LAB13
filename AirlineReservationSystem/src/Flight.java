import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private final String flightNumber;
    private final String fromCity;
    private final String toCity;
    private int availableSeats;
    private final String gate;
    private LocalDateTime departureTime;
    private List<Customer> registeredCustomers;

    public Flight(String flightNumber, String fromCity, String toCity, int availableSeats, String gate) {
        this.flightNumber = flightNumber;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.availableSeats = availableSeats;
        this.gate = gate;
        this.registeredCustomers = new ArrayList<>();
    }
    public void setAvailableSeats(int availableSeats){
        this.availableSeats = availableSeats;
    }
    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getFromCity() { return fromCity; }
    public String getToCity() { return toCity; }
    public int getAvailableSeats() { return availableSeats; }
    public String getGate() { return gate; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public List<Customer> getRegisteredCustomers() { return registeredCustomers; }
}

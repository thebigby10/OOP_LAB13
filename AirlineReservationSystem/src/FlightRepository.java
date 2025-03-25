import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private List<Flight> flightList;

    public FlightRepository() {
        this.flightList = new ArrayList<>();
    }

    public Flight findFlightByNumber(String flightNumber) {
        for (Flight flight : flightList) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    public List<Flight> getFlightList() {
        return flightList;
    }
}

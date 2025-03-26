import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private List<Flight> flightList;

    public FlightRepository() {
        this.flightList = new ArrayList<>();
    }

    // Adds a new flight to the repository
    public void addFlight(Flight flight) {
        flightList.add(flight);
        System.out.println("Flight " + flight.getFlightNumber() + " has been added to the repository.");
    }

    // Finds a flight by flight number
    public Flight findFlightByNumber(String flightNumber) {
        for (Flight flight : flightList) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        System.out.println("Flight " + flightNumber + " not found in the repository.");
        return null;
    }

    // Returns the list of all flights
    public List<Flight> getFlightList() {
        return flightList;
    }
}

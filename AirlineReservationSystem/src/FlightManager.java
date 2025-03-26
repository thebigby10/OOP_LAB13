import java.util.List;

public class FlightManager {

    private FlightRepository flightRepository;

    public FlightManager() {
        this.flightRepository = new FlightRepository();  // Manage flight data
    }

    // Adds a new flight to the repository
    public void addFlight(Flight flight) {
        flightRepository.addFlight(flight);
    }

    // Checks if a flight is already registered
    public boolean isFlightRegistered(String flightNumber) {
        return flightRepository.findFlightByNumber(flightNumber) != null;
    }

    // Books a flight for a customer if seats are available
    public boolean bookFlight(Flight flight, int numOfTickets) {
        if (flight.getAvailableSeats() >= numOfTickets) {
            flight.setAvailableSeats(flight.getAvailableSeats() - numOfTickets);
            return true;
        }
        return false;
    }

    // Cancels the flight booking for a customer
    public void cancelFlight(Flight flight, int numOfTickets) {
        flight.setAvailableSeats(flight.getAvailableSeats() + numOfTickets);
    }
}

import java.util.List;

public class FlightManager {

    private FlightRepository flightRepository;

    public FlightRepository getFlightRepository() {
        return flightRepository;
    }

    public FlightManager() {
        this.flightRepository = new FlightRepository();
    }

    // Adds a new flight to the repository
    public void addFlight(Flight flight) {
        flightRepository.addFlight(flight);
        System.out.println("Flight " + flight.getFlightNumber() + " has been added to the system.");
    }

    // Checks if a flight is already registered
    public boolean isFlightRegistered(String flightNumber) {
        Flight flight = flightRepository.findFlightByNumber(flightNumber);
        if (flight != null) {
            System.out.println("Flight " + flightNumber + " is already registered.");
            return true;
        }
        System.out.println("Flight " + flightNumber + " is not registered.");
        return false;
    }

    // Books a flight for a customer if seats are available
    public boolean bookFlight(Flight flight, int numOfTickets) {
        if (flight.getAvailableSeats() >= numOfTickets) {
            flight.setAvailableSeats(flight.getAvailableSeats() - numOfTickets);
            System.out.println("Successfully booked " + numOfTickets + " tickets for flight " + flight.getFlightNumber());
            return true;
        }
        System.out.println("Failed to book flight " + flight.getFlightNumber() + ". Not enough seats available.");
        return false;
    }

    // Cancels the flight booking for a customer
    public void cancelFlight(Flight flight, int numOfTickets) {
        flight.setAvailableSeats(flight.getAvailableSeats() + numOfTickets);
        System.out.println("Successfully cancelled " + numOfTickets + " tickets for flight " + flight.getFlightNumber());
    }
}

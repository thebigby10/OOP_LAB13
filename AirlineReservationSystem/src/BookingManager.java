public class BookingManager {
    private FlightRepository flightRepository;

    public BookingManager() {
        this.flightRepository = new FlightRepository();
    }

    public boolean bookFlight(String flightNumber, int numOfTickets, Customer customer) {
        Flight flight = flightRepository.findFlightByNumber(flightNumber);
        if (flight != null && flight.getAvailableSeats() >= numOfTickets) {
            flight.setAvailableSeats(flight.getAvailableSeats() - numOfTickets);
            customer.getFlightsRegisteredByUser().add(flight);
            return true;
        }
        return false;
    }

    public boolean cancelFlight(String flightNumber, int numOfTickets, Customer customer) {
        Flight flight = flightRepository.findFlightByNumber(flightNumber);
        if (flight != null) {
            flight.setAvailableSeats(flight.getAvailableSeats() + numOfTickets);
            customer.getFlightsRegisteredByUser().remove(flight);
            return true;
        }
        return false;
    }
}

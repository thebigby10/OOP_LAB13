public class FlightReservation {

    private FlightManager flightManager;

    public FlightReservation() {
        this.flightManager = new FlightManager();  // Delegating to FlightManager
    }

    // Books a flight for a customer if there are enough available seats
    public void bookFlight(String flightNo, int numOfTickets, Customer customer) {
        Flight flight = flightManager.getFlightRepository().findFlightByNumber(flightNo);
        if (flight != null) {
            boolean isBooked = flightManager.bookFlight(flight, numOfTickets);
            if (isBooked) {
                System.out.println("Successfully booked " + numOfTickets + " tickets for flight " + flightNo);
            } else {
                System.out.println("Not enough seats available for flight " + flightNo);
            }
        } else {
            System.out.println("Flight not found: " + flightNo);
        }
    }

    // Cancels a flight for a customer and restores the available seats
    public void cancelFlight(String flightNo, int numOfTickets, Customer customer) {
        Flight flight = flightManager.getFlightRepository().findFlightByNumber(flightNo);
        if (flight != null) {
            flightManager.cancelFlight(flight, numOfTickets);
            System.out.println("Successfully cancelled " + numOfTickets + " tickets for flight " + flightNo);
        } else {
            System.out.println("Flight not found: " + flightNo);
        }
    }
}

public class FlightReservation {
    private BookingManager bookingManager;

    public FlightReservation() {
        this.bookingManager = new BookingManager();
    }

    public void bookFlight(String flightNo, int numOfTickets, Customer customer) {
        boolean isBooked = bookingManager.bookFlight(flightNo, numOfTickets, customer);
        if (isBooked) {
            System.out.println("Successfully booked " + numOfTickets + " tickets for flight " + flightNo);
        } else {
            System.out.println("Failed to book flight " + flightNo);
        }
    }

    public void cancelFlight(String flightNo, int numOfTickets, Customer customer) {
        boolean isCancelled = bookingManager.cancelFlight(flightNo, numOfTickets, customer);
        if (isCancelled) {
            System.out.println("Successfully cancelled " + numOfTickets + " tickets for flight " + flightNo);
        } else {
            System.out.println("Failed to cancel flight " + flightNo);
        }
    }
}

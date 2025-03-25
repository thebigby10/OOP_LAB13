public class Main {
    public static void main(String[] args) {
        FlightScheduler scheduler = new FlightScheduler();
        Flight flight = new Flight("AB123", "New York", "Los Angeles", 200, "G7");
        flight.setDepartureTime(scheduler.scheduleFlight(2));

        Customer customer = new Customer("John Doe", "john@example.com", "password123", "555-1234", "123 Main St", 30);
        
        FlightReservation flightReservation = new FlightReservation();
        flightReservation.bookFlight("AB123", 2, customer);
    }
}

package models;
import java.util.List;

public class FlightManager {

    public void addFlightToCustomer(Customer customer, Flight flight) {
        customer.getFlightsRegisteredByUser().add(flight);
    }

    public boolean isFlightAlreadyRegistered(List<Flight> flights, Flight flight) {
        return flights.contains(flight);
    }

}

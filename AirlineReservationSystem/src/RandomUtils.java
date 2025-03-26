import java.util.Random;

public class RandomUtils {

    private static final Random random = new Random();

    // Generates a random flight number
    public static String generateRandomFlightNumber() {
        String flightNumber = "FL" + (random.nextInt(9000) + 1000); // Generate a random 4-digit number
        System.out.println("Generated random flight number: " + flightNumber);
        return flightNumber;
    }

    // Generates a random number of seats for a flight
    public static int generateRandomSeats() {
        int seats = random.nextInt(100) + 50; // Generate between 50 and 150 seats
        System.out.println("Generated random number of seats: " + seats);
        return seats;
    }
}

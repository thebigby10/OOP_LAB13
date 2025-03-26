import java.util.List;

public class UserAuthenticator {

    // Authenticates a user by checking their email and password
    public String authenticateUser(String email, String password, List<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                System.out.println("Authentication successful for user: " + email);
                return customer.getUserID();  // Return userID if credentials are correct
            }
        }
        System.out.println("Authentication failed for user: " + email);
        return null;  // Return null if authentication fails
    }
}

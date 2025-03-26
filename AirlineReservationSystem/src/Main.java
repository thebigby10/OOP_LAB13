import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Assuming customer collection is already populated
        List<Customer> customers = Customer.getCustomersCollection();

        // Creating RolesAndPermissions and UserAuthenticator instances
        RolesAndPermissions rolesAndPermissions = new RolesAndPermissions();
        
        String email = "john.doe@example.com";  // Example email
        String password = "password123";  // Example password

        // Authenticate the user and check if they are an admin
        boolean isAdmin = rolesAndPermissions.authenticateAndCheckIfAdmin(email, password, customers);

        if (isAdmin) {
            System.out.println("User is an admin.");
        } else {
            System.out.println("User is not an admin or authentication failed.");
        }
    }
}

import java.util.List;

public class UserAuthenticator {
    public String authenticateUser(String email, String password, List<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer.getUserID();
            }
        }
        return null;
    }
}

import java.util.List;

public class CustomerValidator {

    public boolean isEmailUnique(String email, List<Customer> customerCollection) {
        for (Customer customer : customerCollection) {
            if (customer.getEmail().equals(email)) {
                return false; // Email already exists
            }
        }
        return true; // Email is unique
    }
}

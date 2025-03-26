import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class CustomerManager {

    private List<Customer> customers;

    public CustomerManager() {
    }

    public CustomerManager(List<Customer> customers) {
        this.customers = customers;
    }

    // Add a new customer to the list
    public Customer addNewCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer password: ");
        String password = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();
        System.out.print("Enter customer age: ");
        int age = scanner.nextInt();

        Customer newCustomer = new Customer(name, email, password, phone, address, age);
        customers.add(newCustomer);
        System.out.println("Customer added successfully.");
        return newCustomer;
    }

    // Search for a customer by userID
    public Customer searchCustomer(String userID) {
        for (Customer customer : customers) {
            if (customer.getUserID().equals(userID)) {
                System.out.println("Customer found: " + customer);
                return customer;
            }
        }
        System.out.println("Customer with ID " + userID + " not found.");
        return null;
    }

    // Update customer information
    public void updateCustomer(String userID, Scanner scanner) {
        Customer customer = searchCustomer(userID);
        if (customer != null) {
            System.out.print("Enter new name: ");
            customer.setName(scanner.nextLine());
            System.out.print("Enter new email: ");
            customer.setEmail(scanner.nextLine());
            System.out.print("Enter new phone: ");
            customer.setPhone(scanner.nextLine());
            System.out.print("Enter new address: ");
            customer.setAddress(scanner.nextLine());
            System.out.print("Enter new age: ");
            customer.setAge(scanner.nextInt());
            System.out.println("Customer data updated.");
        }
    }

    // Delete a customer from the list
    public void deleteCustomer(String userID) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getUserID().equals(userID)) {
                iterator.remove();
                System.out.println("Customer with ID " + userID + " has been deleted.");
                return;
            }
        }
        System.out.println("Customer with ID " + userID + " not found.");
    }

    // Display all customers
    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
            return;
        }
        System.out.println("List of all customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}

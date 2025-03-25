import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Customer {

    private static final List<Customer> customerCollection = new ArrayList<>();
    private String userID;
    private String email;
    private String name;
    private String phone;
    private final String password;
    private String address;
    private int age;
    private List<Flight> flightsRegisteredByUser;

    public Customer(String name, String email, String password, String phone, String address, int age) {
        this.userID = generateUserID();
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.flightsRegisteredByUser = new ArrayList<>();
    }

    public void addNewCustomer() {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = read.nextLine();
        System.out.println("Enter your email address:");
        String email = read.nextLine();

        // Validate email uniqueness
        CustomerValidator validator = new CustomerValidator();
        while (!validator.isEmailUnique(email, customerCollection)) {
            System.out.println("Email is already in use. Please enter a new email:");
            email = read.nextLine();
        }

        System.out.println("Enter your password:");
        String password = read.nextLine();
        System.out.println("Enter your phone number:");
        String phone = read.nextLine();
        System.out.println("Enter your address:");
        String address = read.nextLine();
        System.out.println("Enter your age:");
        int age = read.nextInt();

        Customer newCustomer = new Customer(name, email, password, phone, address, age);
        customerCollection.add(newCustomer);
        System.out.println("Customer added successfully.");
    }

    private String generateUserID() {
        RandomGenerator random = new RandomGenerator();
        random.randomIDGen();
        return random.getRandomNumber().toString();
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Flight> getFlightsRegisteredByUser() {
        return this.flightsRegisteredByUser;
    }

}

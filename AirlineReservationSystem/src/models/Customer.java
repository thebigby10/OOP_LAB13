import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {
    private final String userID;
    private String email;
    private String name;
    private String phone;
    private final String password;
    private String address;
    private int age;
    private List<Flight> flightsRegisteredByUser;

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
        return flightsRegisteredByUser;
    }

    public void setFlightsRegisteredByUser(List<Flight> flightsRegisteredByUser) {
        this.flightsRegisteredByUser = flightsRegisteredByUser;
    }

    public Customer(String name, String email, String password, String phone, String address, int age) {
        this.userID = generateUniqueUserID(); // Generate unique userID
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.flightsRegisteredByUser = new ArrayList<>();
    }

    private String generateUniqueUserID() {
        return UUID.randomUUID().toString();
    }
}

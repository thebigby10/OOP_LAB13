import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int countNumOfUsers = 1;
        RolesAndPermissions r1 = new RolesAndPermissions();
        FlightManager flightManager = new FlightManager();
        FlightReservation flightReservation = new FlightReservation();
        Customer customerManager = new Customer();
        Scanner read = new Scanner(System.in);

        // Initialize some flight data
        Flight flight1 = new Flight(RandomUtils.generateRandomFlightNumber(), "New York", "Los Angeles", RandomUtils.generateRandomSeats(), "G7");
        flightManager.addFlight(flight1);

        // Initialize the customer collection
        List<Customer> customers = Customer.getCustomersCollection();

        // Display the main menu
        System.out.println("\n\t\t\t\t\t+++++++++++++ Welcome to BAV AirLines +++++++++++++\n\nTo Further Proceed, Please enter a value.");
        System.out.println("\n***** Default Username && Password is root-root ***** Using Default Credentials will restrict you to just view the list of Passengers....\n");
        displayMainMenu();
        int desiredOption = read.nextInt();

        while (desiredOption < 0 || desiredOption > 8) {
            System.out.print("ERROR!! Please enter value between 0 - 8. Enter the value again :\t");
            desiredOption = read.nextInt();
        }

        // Main logic
        do {
            Scanner read1 = new Scanner(System.in);

            // Option 1: Login as Admin
            if (desiredOption == 1) {
                adminLogin(r1, read1, flightManager, flightReservation, customerManager);
            }
            // Option 2: Register Admin
            else if (desiredOption == 2) {
                adminRegistration(r1, read1, countNumOfUsers);
            }
            // Option 3: Passenger Login
            else if (desiredOption == 3) {
                passengerLogin(r1, flightManager, flightReservation, read1);
            }
            // Option 4: Register Passenger
            else if (desiredOption == 4) {
                Customer newCustomer = customerManager.addNewCustomer(read1);
                System.out.println("Passenger registered successfully: " + newCustomer.getName());
            }
            // Option 5: Display User Manual
            else if (desiredOption == 5) {
                manualInstructions();
            }

            // Display the main menu again and get user choice
            displayMainMenu();
            desiredOption = read1.nextInt();
            while (desiredOption < 0 || desiredOption > 8) {
                System.out.print("ERROR!! Please enter value between 0 - 8. Enter the value again :\t");
                desiredOption = read1.nextInt();
            }

        } while (desiredOption != 0); // Exit the program
    }

    // Admin Login
    static void adminLogin(RolesAndPermissions r1, Scanner read1, FlightManager flightManager, FlightReservation flightReservation, CustomerManager customerManager) {
        System.out.print("\nEnter the UserName to login to the Management System: ");
        String username = read1.nextLine();
        System.out.print("Enter the Password to login to the Management System: ");
        String password = read1.nextLine();
        System.out.println();

        if (r1.checkIfAdmin(username, password)) {
            System.out.println("Logged in successfully as \"" + username + "\". You can perform CRUD operations.");
            adminOperations(flightManager, flightReservation, customerManager, read1);
        } else {
            System.out.println("ERROR! Unable to login. Try creating new credentials or register by pressing 4.");
        }
    }

    // Admin Operations: CRUD (Create, Read, Update, Delete) for passengers and flights
    static void adminOperations(FlightManager flightManager, FlightReservation flightReservation, CustomerManager customerManager, Scanner read1) {
        int desiredOption;
        do {
            System.out.println("\n2nd Layer Menu");
            System.out.println("1. Add New Passenger");
            System.out.println("2. Search a Passenger");
            System.out.println("3. Update Passenger Data");
            System.out.println("4. Delete Passenger");
            System.out.println("5. Display All Passengers");
            System.out.println("6. Display All Flights Registered by a Passenger");
            System.out.println("7. Display Registered Passengers in a Flight");
            System.out.println("8. Delete a Flight");
            System.out.println("0. Logout");

            System.out.print("Enter your choice: ");
            desiredOption = read1.nextInt();

            switch (desiredOption) {
                case 1:
                    customerManager.addNewCustomer(read1);
                    break;
                case 2:
                    System.out.print("Enter Customer ID to Search: ");
                    String searchID = read1.nextLine();
                    customerManager.searchCustomer(searchID);
                    break;
                case 3:
                    System.out.print("Enter Customer ID to Update: ");
                    String updateID = read1.nextLine();
                    customerManager.updateCustomer(updateID, read1);
                    break;
                case 4:
                    System.out.print("Enter Customer ID to Delete: ");
                    String deleteID = read1.nextLine();
                    customerManager.deleteCustomer(deleteID);
                    break;
                case 5:
                    customerManager.displayAllCustomers();
                    break;
                case 6:
                    System.out.print("Enter UserID to display flights: ");
                    String userID = read1.nextLine();
                    flightReservation.displayFlightsRegisteredByOneUser(userID);
                    break;
                case 7:
                    System.out.print("Enter Flight Number to display registered passengers: ");
                    String flightNum = read1.nextLine();
                    flightReservation.displayRegisteredUsersForASpecificFlight(flightNum);
                    break;
                case 8:
                    System.out.print("Enter Flight Number to Delete: ");
                    String flightDelete = read1.nextLine();
                    flightManager.deleteFlight(flightDelete);
                    break;
                case 0:
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (desiredOption != 0);
    }

    // Admin Registration
    static void adminRegistration(RolesAndPermissions r1, Scanner read1, int countNumOfUsers) {
        System.out.print("\nEnter the UserName to Register: ");
        String username = read1.nextLine();
        System.out.print("Enter the Password to Register: ");
        String password = read1.nextLine();
        while (r1.checkIfAdmin(username, password)) {
            System.out.println("ERROR! Admin with the same username already exists. Enter new Username.");
            username = read1.nextLine();
            System.out.print("Enter the Password Again: ");
            password = read1.nextLine();
        }

        r1.addAdmin(username, password);
        countNumOfUsers++;
        System.out.println("Admin registered successfully.");
    }

    // Passenger Login
    static void passengerLogin(RolesAndPermissions r1, FlightManager flightManager, FlightReservation flightReservation, Scanner read1) {
        System.out.print("Enter the Email to Login: ");
        String email = read1.nextLine();
        System.out.print("Enter the Password: ");
        String password = read1.nextLine();

        String[] result = r1.isPassengerRegistered(email, password).split("-");
        if (Integer.parseInt(result[0]) == 1) {
            int desiredChoice;
            System.out.println("Logged in successfully as \"" + email + "\".");
            do {
                System.out.println("\n3rd Layer Menu");
                System.out.println("1. Book a Flight");
                System.out.println("2. Update your Data");
                System.out.println("3. Delete your Account");
                System.out.println("4. Display Flight Schedule");
                System.out.println("5. Cancel a Flight");
                System.out.println("6. Display Flights Registered by You");
                System.out.println("0. Logout");

                System.out.print("Enter your choice: ");
                desiredChoice = read1.nextInt();

                switch (desiredChoice) {
                    case 1:
                        flightManager.displayFlightSchedule();
                        System.out.print("Enter flight number: ");
                        String flightNumToBook = read1.nextLine();
                        System.out.print("Enter number of tickets: ");
                        int ticketsToBook = read1.nextInt();
                        flightReservation.bookFlight(flightNumToBook, ticketsToBook, new Customer());
                        break;
                    case 2:
                        // Update passenger info
                        break;
                    case 3:
                        System.out.println("Are you sure you want to delete your account? Enter Y/y to confirm.");
                        char confirmation = read1.nextLine().charAt(0);
                        if (confirmation == 'Y' || confirmation == 'y') {
                            // Delete account logic
                        }
                        break;
                    case 4:
                        flightManager.displayFlightSchedule();
                        break;
                    case 5:
                        // Cancel flight logic
                        break;
                    case 6:
                        // Display registered flights
                        break;
                    case 0:
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } while (desiredChoice != 0);
        } else {
            System.out.println("ERROR! Unable to login. Invalid credentials.");
        }
    }

    // Main Menu Display
    static void displayMainMenu() {
        System.out.println("\n\n\t\t(a) Press 0 to Exit.");
        System.out.println("\t\t(b) Press 1 to Login as Admin.");
        System.out.println("\t\t(c) Press 2 to Register as Admin.");
        System.out.println("\t\t(d) Press 3 to Login as Passenger.");
        System.out.println("\t\t(e) Press 4 to Register as Passenger.");
        System.out.println("\t\t(f) Press 5 to Display the User Manual.");
        System.out.print("\t\tEnter the desired option: ");
    }

    // User Manual Instructions
    static void manualInstructions() {
        System.out.println("Displaying User Manual...");
        // Add manual details here.
    }
}

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int countNumOfUsers = 1;
        RolesAndPermissions r1 = new RolesAndPermissions();
        Flight f1 = new Flight();
        FlightReservation bookingAndReserving = new FlightReservation();
        Customer c1 = new Customer();
        f1.flightScheduler();
        Scanner read = new Scanner(System.in);

        // Initial greeting and instructions
        System.out.println("\n\t\t\t\t\t+++++++++++++ Welcome to BAV AirLines +++++++++++++\n\nTo Further Proceed, Please enter a value.");
        System.out.println("\n***** Default Username && Password is root-root ***** Using Default Credentials will restrict you to just view the list of Passengers....\n");
        displayMainMenu();
        int desiredOption = read.nextInt();
        
        while (desiredOption < 0 || desiredOption > 8) {
            System.out.print("ERROR!! Please enter value between 0 - 8. Enter the value again :\t");
            desiredOption = read.nextInt();
        }

        do {
            Scanner read1 = new Scanner(System.in);

            // Option 1: Login as Admin
            if (desiredOption == 1) {
                adminLogin(r1, c1, read1, desiredOption);
            } else if (desiredOption == 2) {
                adminRegistration(r1, read1, countNumOfUsers);
            } else if (desiredOption == 3) {
                passengerLogin(r1, bookingAndReserving, c1, read1);
            } else if (desiredOption == 4) {
                c1.addNewCustomer();
            } else if (desiredOption == 5) {
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

    // Admin Login Method
    static void adminLogin(RolesAndPermissions r1, Customer c1, Scanner read1, int desiredOption) {
        // Default credentials
        String[][] adminUserNameAndPassword = new String[10][2];
        adminUserNameAndPassword[0][0] = "root";
        adminUserNameAndPassword[0][1] = "root";

        System.out.print("\nEnter the UserName to login to the Management System: ");
        String username = read1.nextLine();
        System.out.print("Enter the Password to login to the Management System: ");
        String password = read1.nextLine();
        System.out.println();

        if (r1.isPrivilegedUserOrNot(username, password) == -1) {
            System.out.println("ERROR! Unable to login. Try creating new credentials or register by pressing 4.");
        } else if (r1.isPrivilegedUserOrNot(username, password) == 0) {
            System.out.println("You've standard privileges to access the data. You can only view customers' data.");
            c1.displayCustomersData(true);
        } else {
            System.out.println("Logged in successfully as \"" + username + "\". You can perform CRUD operations.");
            performAdminActions(c1, read1, desiredOption);
        }
    }

    // Perform Admin Actions
    static void performAdminActions(Customer c1, Scanner read1, int desiredOption) {
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
                    c1.addNewCustomer();
                    break;
                case 2:
                    c1.displayCustomersData(false);
                    System.out.print("Enter the CustomerID to Search: ");
                    String customerID = read1.nextLine();
                    c1.searchUser(customerID);
                    break;
                case 3:
                    c1.displayCustomersData(false);
                    System.out.print("Enter the CustomerID to Update: ");
                    String customerIdToUpdate = read1.nextLine();
                    c1.editUserInfo(customerIdToUpdate);
                    break;
                case 4:
                    c1.displayCustomersData(false);
                    System.out.print("Enter the CustomerID to Delete: ");
                    String customerIdToDelete = read1.nextLine();
                    c1.deleteUser(customerIdToDelete);
                    break;
                case 5:
                    c1.displayCustomersData(false);
                    break;
                case 6:
                    System.out.print("Enter the UserID to display flights registered: ");
                    String userID = read1.nextLine();
                    System.out.println("Displaying flights for user ID: " + userID);
                    break;
                case 7:
                    System.out.print("Enter the Flight Number to display registered passengers: ");
                    String flightNumber = read1.nextLine();
                    System.out.println("Displaying registered passengers for flight: " + flightNumber);
                    break;
                case 8:
                    System.out.print("Enter the Flight Number to delete: ");
                    String flightToDelete = read1.nextLine();
                    break;
                case 0:
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (desiredOption != 0);
    }

    // Admin Registration Method
    static void adminRegistration(RolesAndPermissions r1, Scanner read1, int countNumOfUsers) {
        System.out.print("\nEnter the UserName to Register: ");
        String username = read1.nextLine();
        System.out.print("Enter the Password to Register: ");
        String password = read1.nextLine();
        while (r1.isPrivilegedUserOrNot(username, password) != -1) {
            System.out.println("ERROR! Admin with the same username already exists. Enter new Username.");
            username = read1.nextLine();
            System.out.print("Enter the Password Again: ");
            password = read1.nextLine();
        }

        // Setting the credentials
        adminUserNameAndPassword[countNumOfUsers][0] = username;
        adminUserNameAndPassword[countNumOfUsers][1] = password;

        countNumOfUsers++;
        System.out.println("Admin registered successfully.");
    }

    // Passenger Login Method
    static void passengerLogin(RolesAndPermissions r1, FlightReservation bookingAndReserving, Customer c1, Scanner read1) {
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
                        bookingAndReserving.bookFlight("FL123", 2, new Customer());
                        break;
                    case 2:
                        c1.editUserInfo(result[1]);
                        break;
                    case 3:
                        System.out.println("Are you sure you want to delete your account? Enter Y/y to confirm.");
                        char confirmation = read1.nextLine().charAt(0);
                        if (confirmation == 'Y' || confirmation == 'y') {
                            c1.deleteUser(result[1]);
                        }
                        break;
                    case 4:
                        System.out.println("Displaying flight schedule...");
                        break;
                    case 5:
                        bookingAndReserving.cancelFlight(result[1]);
                        break;
                    case 6:
                        bookingAndReserving.displayFlightsRegisteredByOneUser(result[1]);
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

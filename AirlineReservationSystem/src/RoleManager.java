public class RoleManager {

    private static final String[][] adminCredentials = {
        {"admin", "admin"},
        {"root", "root"}
    };

    // Check if the user has admin privileges based on username and password
    public boolean isAdmin(String username, String password) {
        for (String[] credentials : adminCredentials) {
            if (credentials[0].equals(username) && credentials[1].equals(password)) {
                return true;  // User is an admin
            }
        }
        return false;  // User is not an admin
    }
}

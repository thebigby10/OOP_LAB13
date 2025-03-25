public class RolesAndPermissions {

    private RoleManager roleManager;

    public RolesAndPermissions() {
        this.roleManager = new RoleManager();  // Using RoleManager to handle admin checks
    }
    
    public boolean checkIfAdmin(String username, String password) {
        return roleManager.isAdmin(username, password);
    }
}

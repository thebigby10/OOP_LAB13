## Refactor initial plannings
- seperate the classes into pacakges for better readablity
- change public fields to private for better encapsulation
- provide appropriate getter-setter
- remove duplicate methods across classes
- seperate programming and business logic
- seperate the classes to maintain SOLID specially SRP

## list of refactoring done
- create pacakge for the classes 

#### Customer class related refacoring
- seperate customer validation from Customer class(into CustomerValidator class)
- update the customer class.remove direct validation logic from customer constructor.
- remove flight related methods to seperate class for SRP. create FlightManager for those logics. 
- update the addNewCustomer method for the new structure. 

#### Flight class related refactoring
- move scheduling and distance logic from Flight class. (FlightScheduler class)
- update FlightReservation class to use BookingManager 
- create a FlightRepository to store flight related data

#### RolesAndPermissions class related refactoing
- seperate RolesAndPermissions classes into RoleManager and PermissionManager
- refactor RolesAndPermissions to use RoleManager and PermissionManager

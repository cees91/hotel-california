package Application.models.Employees;

import Application.models.User;

public class Employee extends User {

    private User user;
    private String employeeId;
    private String accessLevel; //make clear access levels

    Employee() {



    }
    public Employee(User user, String employeeId, String accessLevel) {
        this.user = user;
        this.employeeId = employeeId;
        this.accessLevel = accessLevel;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}

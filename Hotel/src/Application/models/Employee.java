package Application.models;

public class Employee extends User {

    User user;
    String employeeId;
    String accessLevel;

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

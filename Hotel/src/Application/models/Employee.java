package Application.models;

public class Employee extends User {

    User user;
    String employeeId;

    public Employee() {
    }

    public Employee(User user, String employeeId) {
        this.user = user;
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

}

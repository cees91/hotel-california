package Application.models.Employees;

import Application.models.User;

public class Employee extends User {

    private User user;
    private String employeeId;

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
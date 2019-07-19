package Application.models;

import Application.models.User;

public class Employee extends User {

    private User user;
    private String employeeId;

    public Employee(User user, String employeeId) {
        this.setUserName(user.getUserName());
        this.setPassword(user.getPassword());
        this.setType("employee");
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

}

package Application.controllers;

import Application.models.Employees.Employee;
import Application.models.User;

import java.util.ArrayList;

public class EmployeeController extends UserController {

    public String createEmployeeUser(User user, String employeeId){
        Employee employee;
        try {
            employee = new Employee(user, "100");
            employee.setEmployeeId(employeeId);
            employee.setUserName(user.getUserName());
            employee.setPassword(user.getPassword());
//            employee.add(employee);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + employee.getUser_id() + ")";

    }




}

package Application.controllers;

import Application.models.Employee;
import Application.models.Guest;
import Application.models.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class EmployeeController extends UserController {

    public String createEmployeeUser(User user, String employeeId){
        Employee employee = null;
        try {
            employee = new Employee();
            employee.setEmployeeId(employeeId);
            employee.setUserName(user.userName);
            employee.setPassword(generateRandomPassword());
            employees.add(employee);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + employee.getUser_id() + ")";

    }




}

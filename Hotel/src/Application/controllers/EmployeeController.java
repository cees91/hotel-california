package Application.controllers;

import Application.models.Employee;
import Application.models.User;

import java.util.ArrayList;

public class EmployeeController extends UserController {

    public static ArrayList<Employee> employees;

    public String createEmployee(User user, String employeeId){
        Employee employee = null;
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
        return "User succesfully created! (id = " + employee.getUserId() + ")";

    }




}

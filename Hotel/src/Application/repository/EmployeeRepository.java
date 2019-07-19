package Application.repository;

import Application.Interfaces.Repository;
import Application.models.Employee;

import java.util.ArrayList;

public class EmployeeRepository implements Repository<Employee> {

    private static EmployeeRepository instance = null;
    private ArrayList<Employee> employees = new ArrayList<>();

    private EmployeeRepository() {
        //Read the CSV and bind data to bookedRooms

    }

    public static EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }

    @Override
    public void create(Employee employee) {

    }

    @Override
    public void update(int userId) {

    }

    @Override
    public void remove(int userId) {

    }
}

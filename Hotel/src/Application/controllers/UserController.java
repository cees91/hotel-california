package Application.controllers;

import Application.models.Employee;
import Application.models.Guest;
import Application.models.User;
import Application.repository.UserRepository;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class UserController {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Guest> guests = GuestController.guests;
    ArrayList<Employee> employees = EmployeeController.employees;


    public ArrayList<User> fillUserlist(ArrayList<Guest> guests, ArrayList<Employee> employees) {
        users.addAll(guests);
        users.addAll(employees);
        return users;
    }

    public int findUser(int userId) throws Exception {
        return UserRepository.getInstance().findUserIndexById(userId);
    }

    public String deleteUser(int userId) {
        try {
            UserRepository.getInstance().remove(userId);
        } catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted! (id = " + userId + ")";

    }

//    public String updateUserName(User user) {
//        try {
//            UserRepository.getInstance().updateUser(user);
//        } catch (Exception ex) {
//            return "Error updating the username: " + ex.toString();
//        }
//        return "Username succesfully updated!";
//
//    }

    public void resetPassword(int userId) {
        try {
            UserRepository.getInstance().resetPassword(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String generateRandomPassword() {
        final int LENGTH = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";
        String password = new Random().ints(LENGTH, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());

        return password;
    }
}

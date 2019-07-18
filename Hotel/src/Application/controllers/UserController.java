package Application.controllers;

import Application.models.Employees.Employee;
import Application.models.Guest;
import Application.models.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class UserController {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Guest> guests = GuestController.guests;
    ArrayList<Employee> employees = new ArrayList<>();


    public ArrayList<User> fillUserlist(ArrayList<Guest> guests, ArrayList<Employee> employees) {
        users.addAll(guests);
        users.addAll(employees);
        return users;
    }

    public int findUserIndex(int userId) throws Exception {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUser_id() == userId) {
                return i;
            }
        }
        throw new Exception("User not found");
    }

    public String deleteGuestUser(int userId) {
        try {
            users.remove(findUserIndex(userId));
        } catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted! (id = " + userId + ")";

    }

    public String updateUserName(int userId, String userName) {
        try {
            users.get(findUserIndex(userId)).setUserName(userName);
        } catch (Exception ex) {
            return "Error updating the username: " + ex.toString();
        }
        return "Username succesfully updated! (id = " + userId + ")";

    }

    public void resetPassword(int userId) {
        try {

            User user = users.get(userId);
            user.setPassword(generateRandomPassword());

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

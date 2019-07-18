package Application.repository;

import Application.Interfaces.Repository;
import Application.models.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class UserRepository implements Repository {

    private static UserRepository instance = null;
    private ArrayList<User> users = new ArrayList<>();

    private UserRepository() {
        //Read the CSV and bind data to bookedRooms

    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public int findUserIndexById(int userId) throws Exception {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId) {
                return i;
            }
        }
        throw new Exception("User not found");
    }

    @Override
    public void remove(int userId) throws Exception {
        users.remove(findUserIndexById(userId));
    }

    @Override
    public void create(Object item) {

    }

    @Override
    public void update(int userId) throws Exception {
        User user = users.get(findUserIndexById(userId));
        if(user.getType().equals("guest")){
            GuestRepository.getInstance().update(user.getUserId());
        }
        else {
            EmployeeRepository.getInstance().update(user.getUserId());
        }

    }

    public void resetPassword(int userId) {
            User user = users.get(userId);
            user.setPassword(generateRandomPassword());
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

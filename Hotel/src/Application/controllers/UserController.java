package Application.controllers;

import Application.models.User;

import java.util.ArrayList;

public class UserController {

    ArrayList<User> users = new ArrayList<User>();

    public String createUser(String name, String password){
        User user = null;
        try {
            user = new User(name, password);
            users.add(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getUser_id() + ")";

    }

    public int findUserIndex(int userId) throws Exception {
        for(int i = 0; i<users.size(); i++){
            if(users.get(i).getUser_id() == userId){
                return i;
            }
        }
        throw new Exception("User not found");
    }

    public String deleteUser(int userId){
        try {
            users.remove(findUserIndex(userId));
        }
        catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted! (id = " + userId + ")";

    }


}

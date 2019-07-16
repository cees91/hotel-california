package Application.models;

public class User {

    public int user_id = 1;
    public String userName;
    private String password;
    public static int count = 1;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.user_id = count++;
    }

    public User(int userId) {
        this.user_id = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }
}

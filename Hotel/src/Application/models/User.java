package Application.models;

public class User {

    private int user_id = 1;
    private String userName;
    private String password;
    private static int count = 1;

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
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }
}

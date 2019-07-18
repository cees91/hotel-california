package Application.models;

public class User {

    private int userId = 1;
    private String userName;
    private String password;
    private static int count = 1;
    private String type;

    public User() {
    }

    public User(String userName, String password, String type) {
        this.userName = userName;
        this.password = password;
        this.userId = count++;
        this.type = type;
    }

    public User(int userId) {
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

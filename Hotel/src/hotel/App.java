package hotel;


public class App {
    public static void main(String[] args) {
        Terminal console = new Terminal();
        String welcomeScreen = "Welcome to the hotel, please select an option: \n" +
                "1: Look for rooms.";
        console.startTerminal(null,welcomeScreen);
    }
}

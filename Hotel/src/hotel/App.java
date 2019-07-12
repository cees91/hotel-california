package hotel;


import controllers.Hotel;
import utils.Terminal;

public class App {
    public static void main(String[] args) {
        Terminal console = new Terminal();
        Hotel hotel = new Hotel();
        String welcomeScreen = "Welcome to the hotel, please select an option: \n" +
                "1: Look for rooms. \n" +
                "2: Check booking. \n" +
                "3: Log in. \n" +
                "4: Contact information. \n";
        console.startTerminal(null,welcomeScreen,hotel);
    }
}

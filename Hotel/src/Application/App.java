package Application;


import Application.controllers.BookingController;
import Application.controllers.RoomController;
import Application.models.Booking;
import Application.repository.BookingRepository;
import Application.utils.Terminal;

import java.awt.print.Book;

public class App {

    public static void main(String[] args) {
        Terminal console = new Terminal();
        String welcomeScreen = "Welcome to the Application, please select an option: \n" +
                "1: Look for rooms. \n" +
                "2: Check booking. \n" +
                "3: Log in. \n" +
                "4: Contact information. \n";
        console.startTerminal(null,welcomeScreen);
    }
}

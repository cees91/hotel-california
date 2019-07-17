package Application;


import Application.controllers.*;
import Application.models.Booking;
import Application.models.Guest;
import Application.models.User;
import Application.utils.Terminal;

import java.awt.print.Book;

public class App {

    public static void main(String[] args) {
        RoomController hotel = new RoomController();
        BookingController booking = new BookingController();
        Terminal console = new Terminal(hotel,booking);
        String welcomeScreen = "Welcome to the Application, please select an option: \n" +
                "1: Look for rooms. \n" +
                "2: Check booking. \n" +
                "3: Log in. \n" +
                "4: Contact information. \n";
        console.startTerminal(null,welcomeScreen);

    }
}

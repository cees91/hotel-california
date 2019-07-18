package Application.utils;

import Application.controllers.BookingController;
import Application.controllers.RoomController;
import Application.controllers.UserController;
import Application.models.Booking;
import Application.models.User;

import java.util.Scanner;

public class Terminal {
    private final String welcomeScreen = "Welcome to the Application, please select an option: \n" +
            "1: Look for rooms. \n" +
            "2: Check booking. \n" +
            "3: Log in. \n" +
            "4: Contact information. \n";
    private RoomController roomController;
    private BookingController bookingController;
    private UserController userController;

    public Terminal(){
        this.roomController = new RoomController();
        this.bookingController = new BookingController();
        this.userController = new UserController();
    }

    public void startTerminal(String previousInput, String currentScreen) {
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(currentScreen);
        String newInput = terminalInput.nextLine();
        String input = previousInput != null ? previousInput + "," + newInput : newInput;
        checkKeyChoice(input, newInput, currentScreen);


    }

    private void checkKeyChoice(String input, String newInput, String currentScreen) {
        if (newInput.equals("q")) {
            System.out.println("Exiting Application app");
        } else if (newInput.equals("b")) {
            goOneScreenBack(input);
        } else {
            String current = processInput(input);
            startTerminal(input, current);
        }
    }

    private void goOneScreenBack(String input) {
        String[] tempInput = input.split(",");
        String removeChar = tempInput[tempInput.length - 2];
        input = input.replaceAll("\\,?" + removeChar + ",b", "");

        if (input.length() < 1) {
            startTerminal(null, this.welcomeScreen);
        } else {
            String current = processInput(input);
            startTerminal(input, current);
        }
    }

    private String processInput(String input) {
        String current = "";
        switch (input) {
            case "1":
                // specify date and number of people
                // needed for later steps -> see room availability
                Booking newBooking = this.bookingController.specifyGuestsAndDates();
                if(newBooking != null) {
                    newBooking = this.roomController.bookRooms(newBooking);
                    this.bookingController.createAndSaveBooking(newBooking);
                }
                break;
            case "2":
                // check booking
//                this.booking.createBooking();
                System.out.println(this.bookingController.showBookings());

                break;
            case "2,1":
                break;
            case "2,2":
                break;
            case "3":
                break;
            default:
                current = "";
                break;

        }
        current += "b: Go back \n";
        current += "q: Quit application";
        return current;
    }

}

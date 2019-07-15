package Application.utils;

import Application.controllers.BookingController;
import Application.controllers.RoomController;
import Application.Enums.ERoomType;

import java.util.Scanner;

public class Terminal {

    private final String welcomeScreen = "Welcome to the Application, please select an option: \n" +
            "1: Look for rooms. \n" +
            "2: Check booking. \n" +
            "3: Log in. \n" +
            "4: Contact information. \n";
    private RoomController hotel;
    private BookingController booking;

    public Terminal(RoomController hotel, BookingController booking){
        this.hotel = hotel;
        this.booking = booking;
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
                boolean isSetUp = this.booking.specifyGuestsAndDates();
                if(isSetUp) {
                    System.out.println(input);
                    current = this.hotel.showRoomTypes();
                }
                break;
            case "1,1":
                ERoomType type = ERoomType.Single;
                boolean isEnoughRoom = this.hotel.checkRoomAvailability(type, this.booking);
                if(isEnoughRoom){
                    // go to booking
                    this.hotel.showSelectedRooms(this.booking.getBooking());
                } else {

                    System.out.println("There are not enough rooms of this type available for the number of guests.");
                }
                break;
            case "1,2":
                ERoomType type2 = ERoomType.Double;
//                current = this.hotel.checkRoomAvailability(type2);
                break;
            case "1,3":
                ERoomType type3 = ERoomType.TwoDouble;
//                current = this.hotel.checkRoomAvailability(type3);
                break;
            case "2":
                // check booking
                this.booking.createBooking();
                System.out.println(this.booking.showBookings());

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

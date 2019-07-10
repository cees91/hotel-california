package hotel;

import java.util.HashMap;
import java.util.Scanner;

public class Terminal {
    public void startTerminal(String previousInput, String currentScreen){
        Scanner terminalInput = new Scanner(System.in);
        System.out.println(currentScreen);
        String newInput = terminalInput.nextLine();
        String input = previousInput != null? previousInput +","+ newInput:  newInput;

        if(newInput.equals("q")) {
            System.out.println("Exiting hotel app");
        } else{
            System.out.println(input);
            String current = processInput(input);
            startTerminal(input, current);
        }
    }

    private String processInput(String input){
        String current ="";
        switch (input){
            case "1":
                // check rooms
//                current = Hotel.showRoomTypes();
                break;
            case "1,1":
                // current = Hotel.showStandardRooms();
                break;
            case "1,2":
                // current = Hotel.showDeluxeRooms();
                break;
            case "1,3":
                // current = Hotel.showPresidentialRooms();
                break;
            case "2":
                // check booking
                // current = Booking.showBooking();
                current ="test";
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
        return current;
    }
    private String getCurrentScreen(String input){
        String firstScreen = "1: Look for rooms.";
        if(input.equals("1")){
            firstScreen = "What kind of room would you like? \n"+
                    "1: Standard \n"+
                    "2: Deluxe \n" +
                    "3: Presidential";
        }
        return firstScreen;
    }
}

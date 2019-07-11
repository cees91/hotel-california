package hotel;

import java.util.HashMap;
import java.util.Scanner;

public class Terminal {
    public void startTerminal(String previousInput, String currentScreen, Hotel hotel){
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(currentScreen);
        String newInput = terminalInput.nextLine();
        String input = previousInput != null? previousInput +","+ newInput:  newInput;

        if(newInput.equals("q")) {
            System.out.println("Exiting hotel app");
        } else{
            System.out.println(input);



            String current = processInput(input,hotel);
            startTerminal(input, current, hotel);
        }
    }

    private String processInput(String input, Hotel hotel){
        String current ="";

        switch (input){
            case "1":
                // check rooms
                current = hotel.showRoomTypes();
                break;
            case "1,1":
                // current = Hotel.showStandardRooms();
                RoomType type = RoomType.Single;
                current = hotel.showRooms(type);
                break;
            case "1,2":
                // current = Hotel.showDeluxeRooms();
                RoomType type2 = RoomType.Double;
                current = hotel.showRooms(type2);
                break;
            case "1,3":
                // current = Hotel.showPresidentialRooms();
                RoomType type3 = RoomType.TwoDouble;
                current = hotel.showRooms(type3);
                break;
            case "2":
                // check booking
                // current = Booking.showBooking();
                current = "test";
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

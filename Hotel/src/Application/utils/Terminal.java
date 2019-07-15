package Application.utils;

import Application.controllers.RoomController;
import Application.Enums.ERoomType;

import java.util.Scanner;

public class Terminal {

    private final String welcomeScreen = "Welcome to the Application, please select an option: \n" +
            "1: Look for rooms. \n" +
            "2: Check booking. \n" +
            "3: Log in. \n" +
            "4: Contact information. \n";

    public void startTerminal(String previousInput, String currentScreen, RoomController hotel) {
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(currentScreen);
        String newInput = terminalInput.nextLine();
        String input = previousInput != null ? previousInput + "," + newInput : newInput;
        checkKeyChoice(input, newInput, currentScreen, hotel);

    }

    private void checkKeyChoice(String input, String newInput, String currentScreen, RoomController hotel) {
        if (newInput.equals("q")) {
            System.out.println("Exiting Application app");
        } else if (newInput.equals("b")) {
            goOneScreenBack(input, hotel);
        } else {
            String current = processInput(input, hotel);
            startTerminal(input, current, hotel);
        }
    }

    private void goOneScreenBack(String input, RoomController hotel) {
        String[] tempInput = input.split(",");
        String removeChar = tempInput[tempInput.length - 2];
        input = input.replaceAll("\\,?" + removeChar + ",b", "");

        if (input.length() < 1) {
            startTerminal(null, this.welcomeScreen, hotel);
        } else {
            String current = processInput(input, hotel);
            startTerminal(input, current, hotel);
        }
    }

    private String processInput(String input, RoomController hotel) {
        String current = "";
        switch (input) {
            case "1":
                // specify date and number of people
                // needed for later steps -> see room availability
                current = hotel.showRoomTypes();
                break;
            case "1,1":
                ERoomType type = ERoomType.Single;
                current = hotel.checkRoomAvailability(type);
                break;
            case "1,2":
                ERoomType type2 = ERoomType.Double;
                current = hotel.checkRoomAvailability(type2);
                break;
            case "1,3":
                ERoomType type3 = ERoomType.TwoDouble;
                current = hotel.checkRoomAvailability(type3);
                break;
            case "2":
                // check booking

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

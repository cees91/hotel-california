package Application.controllers;

import Application.Enums.ERoomType;
import Application.Interfaces.SaveBooking;
import Application.models.Booking;
import Application.models.Rooms;
import Application.models.User;
import Application.utils.CSVReader;
import Application.utils.CSVWriter;
import Application.utils.DBSaver;

import java.util.Scanner;

public class RoomController {
    Rooms[] rooms;

    public RoomController() {
        this.rooms = readCSVFile();
    }

    private Rooms[] readCSVFile() {
        CSVReader reader = new CSVReader();
        Rooms[] csvRooms = reader.csvReader();
        return csvRooms;
    }

    ;
    public void bookRooms(Booking newBooking){
        ERoomType roomType = showRoomTypes(newBooking);
        boolean isAvailable = checkRoomAvailability(roomType, newBooking);
        if(isAvailable){
//            Guest guest = checkLogin();
            Booking completedBooking = setUserDetails(newBooking);
            saveBooking(completedBooking,"csv");
        }

    }
    private ERoomType showRoomTypes(Booking newBooking) {
        String types = "";
        int i = 1;
        for (ERoomType currentType : ERoomType.values()) {
            types += i + ": " + currentType.name() + "\n";
            i++;
        }
        Scanner terminal = new Scanner(System.in);
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(types);
        ERoomType roomType = ERoomType.values()[Integer.parseInt(terminal.nextLine())];
        return roomType;
    }

    private boolean checkRoomAvailability(ERoomType type, Booking currentBooking) {
        int i = 1;
        Rooms[] rooms = new Rooms[100];
        int numberOfGuests = currentBooking.getNumberOfGuests();
        for (Rooms currentRoom : this.rooms) {
            if (currentRoom.isAvailable() && currentRoom.getType() == type && numberOfGuests > 0) {
                numberOfGuests -= currentRoom.getAdults();
                rooms[i] = currentRoom;
                i++;
            }
        }
        currentBooking.setBookedRooms(rooms);
        if(numberOfGuests == 0){
            return true;
        }
        return false;
    }
    private void checkLogin(){
//        Guest gu
    }
    private void setUserDetails(Booking booking){
        Scanner scanner = new Scanner(System.in);
        System.out.println("First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();
        System.out.println("City: ");
        String city = scanner.nextLine();
        System.out.println("Telephone number: ");
        String telephoneNumber = scanner.nextLine();
//        booking.setHeadBooker();
    }
    private void saveBooking(Booking booking, String type){
        SaveBooking saveInstance;
        if(type.equals("csv")) {
            saveInstance = new CSVWriter();
        } else{
            saveInstance = new DBSaver();
        }
        saveInstance.saveBooking(booking);
    }

}

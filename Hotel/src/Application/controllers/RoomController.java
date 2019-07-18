package Application.controllers;

import Application.Enums.ERoomType;
import Application.models.Booking;
import Application.models.Room;
import Application.utils.CSVReader;

import java.util.Scanner;

public class RoomController {
    private Room[] rooms;

    public RoomController() {
        this.rooms = readCSVFile();
    }

    private Room[] readCSVFile() {
        CSVReader reader = new CSVReader();
        Room[] csvRooms = reader.csvReader();
        return csvRooms;
    }

    ;
    public Booking bookRooms(Booking newBooking){
        ERoomType roomType = showRoomTypes(newBooking);
        boolean isAvailable = checkRoomAvailability(roomType, newBooking);
        if(isAvailable){
            return newBooking;
        }
        return null;
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
        Room[] rooms = new Room[100];
        int numberOfGuests = currentBooking.getNumberOfGuests();
        for (Room currentRoom : this.rooms) {
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


}

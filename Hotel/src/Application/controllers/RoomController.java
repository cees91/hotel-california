package Application.controllers;

import Application.Enums.ERoomType;
import Application.models.Booking;
import Application.models.Rooms;
import Application.utils.CSVReader;

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

    public void showRoomTypes(Booking newBooking) {
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
        checkRoomAvailability(roomType,newBooking);
    }

    private void checkRoomAvailability(ERoomType type, Booking currentBooking) {
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

    }

    public void showSelectedRooms(Booking booking) {
        Rooms[] rooms = booking.getBookedRooms();
        for (Rooms currentRoom : rooms) {
            if(currentRoom != null) {
                System.out.println("Selected rooms: " + currentRoom.getRoomNumber() + "type: " + currentRoom.getType());
            }

        }
    }

}

package Application.controllers;

import Application.Enums.ERoomType;
import Application.models.Booking;
import Application.models.Rooms;
import Application.utils.CSVReader;

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

    public String showRoomTypes() {
        String types = "";
        int i = 1;
        for (ERoomType currentType : ERoomType.values()) {
            types += i + ": " + currentType.name() + "\n";
            i++;
        }

        return types;
    }

    public boolean checkRoomAvailability(ERoomType type, BookingController booking) {
        String roomList = "";
        int i = 1;
        Booking currentBooking = booking.getBooking();
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
        if (numberOfGuests == 0) {
            return true;
        }
        return false;
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

package Application.repository;

import Application.models.Rooms;
import Application.utils.CSVReader;

import java.util.ArrayList;

public class RoomRepository {
    private static RoomRepository instance = null;
    private ArrayList<Rooms> rooms;

    private RoomRepository() {
        CSVReader reader = new CSVReader();
        this.rooms = reader.csvReader();
    }
    private Rooms filterRooms(int roomNumber){
        Rooms room = null;

        for (Rooms currentRoom : this.rooms) {
            if (currentRoom.getRoomNumber() == (roomNumber)) {
                room = currentRoom;
                break;
            }
        }
        return room;
    }
    public ArrayList<Rooms> getRooms() {
        return this.rooms;
    }

    public Rooms findRoom(int roomNumber) throws Exception {
        Rooms room = filterRooms(roomNumber);
        if (room != null) {
            return room;
        } else {
            throw new Exception("Room not found!");
        }
    }
    public void bookRoom(int roomNumber) {
        Rooms room = filterRooms(roomNumber);
        room.setAvailable(false);
    }
    public void freeRoom(int roomNumber){
        Rooms room = filterRooms(roomNumber);
        room.setAvailable(true);
    }

    public void cleanRoom(int roomNumber) {
        Rooms room = filterRooms(roomNumber);
        // room needs a clean getter and setter!
    }

    public static RoomRepository getInstance() {
        if (instance == null) {
            instance = new RoomRepository();
        }
        return instance;
    }
}

package Application.repository;

import Application.models.Room;
import Application.utils.CSVReader;

import java.util.ArrayList;

public class RoomRepository {
    private static RoomRepository instance = null;
    private ArrayList<Room> rooms;

    private RoomRepository() {
        CSVReader reader = new CSVReader();
        this.rooms = reader.csvReader();
    }
    private Room filterRooms(int roomNumber){
        Room room = null;

        for (Room currentRoom : this.rooms) {
            if (currentRoom.getRoomNumber() == (roomNumber)) {
                room = currentRoom;
                break;
            }
        }
        return room;
    }
    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public Room findRoom(int roomNumber) throws Exception {
        Room room = filterRooms(roomNumber);
        if (room != null) {
            return room;
        } else {
            throw new Exception("Room not found!");
        }
    }
    public void bookRoom(int roomNumber) {
        Room room = filterRooms(roomNumber);
        room.setAvailable(false);
    }
    public void freeRoom(int roomNumber){
        Room room = filterRooms(roomNumber);
        room.setAvailable(true);
    }

    public void cleanRoom(int roomNumber) {
        Room room = filterRooms(roomNumber);
        // room needs a clean getter and setter!
    }

    public static RoomRepository getInstance() {
        if (instance == null) {
            instance = new RoomRepository();
        }
        return instance;
    }
}

package Application.repository;

import Application.models.Room;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class RoomRepositoryTest {

    @Test
    public void getRooms() {
    }

    @Test
    public void findRoom() throws Exception{

        RoomRepository repo = RoomRepository.getInstance();
        Room foundRoom= repo.findRoom(6);
        assertEquals(6, foundRoom.getRoomNumber());
    }

    @Test
    public void bookRoom() throws Exception {
        RoomRepository repo = RoomRepository.getInstance();
        Room roomToBook = repo.bookRoom(60); //max of 75 rooms
        assertFalse(roomToBook.isAvailable());
    }

    @Test
    public void freeRoom() throws Exception {
        RoomRepository repo = RoomRepository.getInstance();
        Room roomToFree = repo.freeRoom(60);
        assertTrue(roomToFree.isAvailable());

    }

    @Test
    public void cleanRoom() {
    }

    @Test
    public void getInstance() {
    }
}
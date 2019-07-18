package Application.repository;

import Application.models.Room;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

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
    public void freeRoom() {


    }

    @Test
    public void cleanRoom() {
    }

    @Test
    public void getInstance() {
    }
}
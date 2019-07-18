package applicationTest.repoTests;
import Application.models.Booking;
import Application.repository.BookingRepository;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookingRepositoryTest {

    @Test
    public void deleteBooking() {
        Booking booking = new Booking();
        int expected = 1;
        BookingRepository repo = BookingRepository.getInstance();
        repo.addBooking(booking);
        assertEquals(expected, repo.getBookings().size());
        repo.deleteBooking(booking);
        assertEquals(0, repo.getBookings().size());

    }

    @Test
    public void addBooking() {
        Booking booking = new Booking();
        int expected = 1;
        BookingRepository repo = BookingRepository.getInstance();
        repo.addBooking(booking);
        assertEquals(expected, repo.getBookings().size());
    }
    @Test
    public void findSingleBooking(){
        Booking booking = new Booking();
        Booking booking2 = new Booking();
        Booking booking3 = new Booking();
        BookingRepository repo = BookingRepository.getInstance();
        repo.addBooking(booking);
        repo.addBooking(booking2);
        repo.addBooking(booking3);
        Booking foundBooking = repo.findSingleBooking(booking2);
        assertEquals(booking2.getBookingId(), foundBooking.getBookingId());
    }
    @Test
    public void findMultipleBookings(){
        Booking booking = new Booking();
        Booking booking2 = new Booking();
        Booking booking3 = new Booking();
        BookingRepository repo = BookingRepository.getInstance();
        repo.addBooking(booking);
        repo.addBooking(booking2);
        repo.addBooking(booking3);
        ArrayList<Booking> findList = new ArrayList<>();
        findList.add(booking2);
        findList.add(booking3);
        ArrayList<Booking> foundBookings = repo.findMultipleBookings(findList);
        assertEquals(findList.size(), foundBookings.size());
    }
}
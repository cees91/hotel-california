package applicationTest.repoTests;
import Application.models.Booking;
import Application.models.Guest;
import Application.repository.BookingRepository;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookingRepositoryTest {

    @Test
    public void deleteBooking() {
        Booking booking = new Booking();
        Guest guest = new Guest();
        guest.setLastName("jansen");
        booking.setHeadBooker(guest);
        int expected = 1;
        BookingRepository repo = BookingRepository.getInstance();
        repo.create(booking);
        assertEquals(expected, repo.getBookings().size());
        repo.deleteBooking("jansen", booking.getBookingId());
        assertEquals(0, repo.getBookings().size());

    }

    @Test
    public void addBooking() {
        Booking booking = new Booking();
        int expected = 1;
        BookingRepository repo = BookingRepository.getInstance();
        repo.create(booking);
        assertEquals(expected, repo.getBookings().size());
    }
    @Test
    public void findSingleBooking(){
        Booking booking = new Booking();
        Booking booking2 = new Booking();
        Guest guest = new Guest();
        guest.setLastName("jansen");
        booking2.setHeadBooker(guest);
        Booking booking3 = new Booking();
        BookingRepository repo = BookingRepository.getInstance();
        repo.create(booking);
        repo.create(booking2);
        repo.create(booking3);
        Booking foundBooking = repo.findSingleBooking("jansen", booking2.getBookingId());
        assertEquals(booking2.getBookingId(), foundBooking.getBookingId());
    }
    @Test
    public void findMultipleBookings(){
        Booking booking = new Booking();
        Booking booking2 = new Booking();
        Booking booking3 = new Booking();
        BookingRepository repo = BookingRepository.getInstance();
        repo.create(booking);
        repo.create(booking2);
        repo.create(booking3);
        ArrayList<Booking> findList = new ArrayList<>();
        findList.add(booking2);
        findList.add(booking3);
        ArrayList<Booking> foundBookings = repo.findMultipleBookings(findList);
        assertEquals(findList.size(), foundBookings.size());
    }
}
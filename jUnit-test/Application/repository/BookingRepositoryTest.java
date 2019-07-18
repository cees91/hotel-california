package Application.repository;

import Application.models.Booking;
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
    public void findSingleBooking(){
        Booking booking = new Booking();
        int expected = 1;
        BookingRepository repo = BookingRepository.getInstance();

    }
}
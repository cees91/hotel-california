package Application.repository;

import Application.models.Booking;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class BookingRepository {

    private static BookingRepository instance = null;
    private ArrayList<Booking> bookings = new ArrayList<>();

    private BookingRepository() {
        //Read the CSV and bind data to bookings

    }

    //CRUD operations for bookings

    //CREATE booking

    //UPDATE booking


    //DELETE booking
    public void deleteBooking(Booking bookingToDelete) {
        String bookingIdToDelete = bookingToDelete.getBookingId();
        for (Booking singleBooking : bookings) {
            if (singleBooking.getBookingId().equals(bookingIdToDelete)) {
                //do some CSV writing magic
            }
        }
    }

    public static BookingRepository getInstance() {
        if (instance == null) {
            instance = new BookingRepository();
        }
        return instance;
    }
}

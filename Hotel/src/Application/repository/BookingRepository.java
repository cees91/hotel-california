package Application.repository;

import Application.models.Booking;

import Application.utils.CSVReader;

import java.util.ArrayList;


public class BookingRepository {

    private static BookingRepository instance = null;
    //maybe check rooms that are not available?
    private ArrayList<Booking> bookings = new ArrayList<>();

    private BookingRepository() {
        //can't use CSV reader because it only returns rooms, not bookings

    }


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

    public void saveBooking(Booking booking) {

    }
}

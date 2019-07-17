package Application.repository;

import Application.models.Booking;

import java.util.ArrayList;


public class BookingRepository {

    private static BookingRepository instance = null;
    private ArrayList<Booking> bookedRooms = new ArrayList<>();

    private BookingRepository() {
        //Read the CSV and bind data to bookedRooms

    }

    //CRUD operations for bookings

    public void deleteBooking(Booking bookingToDelete) {
        String bookingId = bookingToDelete.getBookingId();
        for (Booking singleBooking : bookedRooms) {
            if (singleBooking.getBookingId() == bookingId) {
                System.out.println("boop");
            }
        }

//        public static BookingRepository getInstance() {
//            if (instance == null) {
//                instance = new BookingRepository();
//            }
//            return instance;
//        }


    }
}

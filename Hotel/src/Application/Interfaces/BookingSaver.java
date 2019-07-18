package Application.Interfaces;

import Application.models.Booking;

import java.util.ArrayList;

public interface BookingSaver {
    void saveBooking(Booking booking);
    void saveBookings(ArrayList<Booking> bookings);
    void removeBooking(int index);
}

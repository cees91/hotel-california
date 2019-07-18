package Application.utils;

import Application.Interfaces.BookingSaver;
import Application.models.Booking;

import java.util.ArrayList;

public class DBSaver implements BookingSaver {
    @Override
    public void saveBooking(Booking booking) {
    }
    public void removeBooking(int i){}
    public void saveBookings(ArrayList<Booking> booking){};
}

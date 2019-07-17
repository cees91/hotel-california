package Application.utils;

import Application.models.Booking;

import java.util.ArrayList;

public class BookingSingleton {
    private static BookingSingleton instance = null;
    ArrayList<Booking> bookingList = new ArrayList<>();

    public BookingSingleton(){

    }
    public void setbookings(ArrayList<Booking> bookings){
        this.bookingList = bookings;
    }

    public ArrayList<Booking> getBookings(){
        return this.bookingList;
    }

    public static BookingSingleton getInstance(){
        if(instance == null){
            instance = new BookingSingleton();
        }
        return instance;
    }
}

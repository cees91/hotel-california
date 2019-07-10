package hotel.bookings;

import hotel.Rooms;
import hotel.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Booking {


    String bookingId;

    // variables regarding payment
    boolean bookingPayed;
    double price;
    double amountPayed;

    // the user that booked the room(s)
    User headBooker;

    // list of rooms that are booked
    Rooms[] bookedRooms;

    // enum variables
    bookingStatus status;
    paymentMethod method;

    // dates
    Date startDate;
    Date endDate;
    Date bookingDate;

    Booking(Rooms[] roomsBooked, User booker, Date start, Date end, Date booked) {
        this.bookingId = UUID.randomUUID().toString();
        this.bookedRooms = roomsBooked;
        this.headBooker = booker;
        this.startDate = start;
        this.endDate = end;
        this.bookingDate = booked;
    }

    public boolean isBookingPayed() {
        return bookingPayed;
    }
    public void setBookingPayed(boolean bookingPayed) {
        this.bookingPayed = bookingPayed;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public bookingStatus getBookingStatus() {
        return this.status;
    }
    public void setBookingStatus(bookingStatus stat) {
        this.status = stat;
    }

    public paymentMethod getPaymentMethod() {
        return this.method;
    }
    public void setpaymentMethod(paymentMethod method) {
        this.method = method;
    }

    public double getAmountPayed() {
        return amountPayed;
    }
    public void setAmountPayed(double amountPayed) {
        this.amountPayed = amountPayed;
    }

    enum bookingStatus {
        received,
        //processed, // do we really need this?
        accepted,
        declined
    }

    enum paymentMethod {
        cash,
        creditcard,
        debitcard,
        alipay
    }

}

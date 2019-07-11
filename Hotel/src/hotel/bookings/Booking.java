package hotel.bookings;

import hotel.Rooms;
import hotel.User;

import java.util.Date;
import java.util.UUID;

public class Booking {

    private String bookingId;

    // variables regarding payment
    private boolean bookingPayed;
    private double price;
    private double amountPayed;

    // the user that booked the room(s)
    private User headBooker;

    // list of rooms that are booked
    private Rooms[] bookedRooms;

    // enum variables
    private bookingStatus status;
    private paymentMethod method;

    // dates
    private Date startDate;
    private Date endDate;
    private Date bookingDate;

    Booking(Rooms[] roomsBooked, User booker, Date start, Date end, Date booked) {
        this.bookingId = UUID.randomUUID().toString();
        this.bookedRooms = roomsBooked;
        this.headBooker = booker;
        this.startDate = start;
        this.endDate = end;
        this.bookingDate = booked;
    }

    public boolean isBookingPayed() {
        return this.bookingPayed;
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
        return this.amountPayed;
    }
    public void setAmountPayed(double amountPayed) {
        this.amountPayed = amountPayed;
    }

    public Rooms[] getBookedRooms() {
        return this.bookedRooms;
    }
    public void setBookedRooms(Rooms[] bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public Date getStartDate() {
        return this.startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getBookingDate() {
        return this.bookingDate;
    }
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
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

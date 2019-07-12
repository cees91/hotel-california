package Application.models;

import java.util.Date;
import java.util.UUID;
import Application.Enums.EBookingStatus;
import Application.Enums.EPaymentMethod;

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
    private EBookingStatus bookingStatus;
    private EPaymentMethod paymentMethod;

    // dates
    private Date startDate;
    private Date endDate;
    private Date bookingDate;

    // basic constructor without arguments
    Booking() {
        this.bookingId = UUID.randomUUID().toString();
        this.bookingDate = new Date(); // creating a Date without specifying a date gives it the date of today
    }

    // constructor with user and start and end date
    Booking(User headBooker, Date startDate, Date endDate) {
        this.bookingId = UUID.randomUUID().toString();
        this.headBooker = headBooker;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingDate = new Date();
    }

    // full constructor
    Booking(Rooms[] bookedRooms, User headBooker, Date startDate, Date endDate) {
        this.bookingId = UUID.randomUUID().toString();
        this.bookedRooms = bookedRooms;
        this.headBooker = headBooker;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingDate = new Date();
    }

    public boolean isBookingPayed() {
        return this.bookingPayed;
    }
    public void setBookingPayed(boolean bookingPayed) {
        this.bookingPayed = bookingPayed;
    }

    public String getBookingId() {
        return bookingId;
    }
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public User getHeadBooker() {
        return this.headBooker;
    }
    public void setHeadBooker(User headBooker) {
        this.headBooker = headBooker;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
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

    public EBookingStatus getBookingStatus() {
        return this.bookingStatus;
    }
    public void setBookingStatus(EBookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public EPaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }
    public void setPaymentMethod(EPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getBookingDate() {
        return this.bookingDate;
    }
}

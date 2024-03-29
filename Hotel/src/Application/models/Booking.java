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
    private Guest headBooker;

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    private int numberOfGuests;

    // list of rooms that are booked
    private Room[] bookedRooms;

    // enum variables
    private EBookingStatus bookingStatus;
    private EPaymentMethod paymentMethod;

    // dates
    private Date startDate;
    private Date endDate;
    private Date bookingDate;

    // basic constructor without arguments
    public Booking() {
        this.bookingId = UUID.randomUUID().toString();
        this.bookingDate = new Date(); // creating a Date without specifying a date gives it the date of today
    }

    // constructor with amount of guests and start and end date
    public Booking(int numberOfGuests, Date startDate, Date endDate) {
        this.bookingId = UUID.randomUUID().toString();
        this.numberOfGuests = numberOfGuests;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingDate = new Date();
    }

    // constructor with user, amount of guests and start and end date
    public Booking(Guest headBooker, int numberOfGuests, Date startDate, Date endDate) {
        this.bookingId = UUID.randomUUID().toString();
        this.numberOfGuests = numberOfGuests;
        this.headBooker = headBooker;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingDate = new Date();
    }

    // full constructor

    public Booking(Room[] bookedRooms, Guest headBooker, int numberOfGuests, Date startDate, Date endDate) {
        this.bookingId = UUID.randomUUID().toString();
        this.bookedRooms = bookedRooms;
        this.headBooker = headBooker;
        this.numberOfGuests = numberOfGuests;
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

    public Guest getHeadBooker() {
        return this.headBooker;
    }
    public void setHeadBooker(Guest headBooker) {
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

    public Room[] getBookedRooms() {
        return this.bookedRooms;
    }
    public void setBookedRooms(Room[] bookedRooms) {
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

package Application.controllers;

import Application.models.Booking;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class BookingController {
    private Booking[] bookings = new Booking[0];
//    private Booking booking = new Booking();
    private int numberOfBookings = 0;


//    public String newBooking() {
//        Booking[] newBookingsArray = Arrays.copyOf(this.bookings, (this.bookings.length + 1));
//        Booking newbooking = new Booking();
//        newBookingsArray[this.numberOfBookings] = newbooking;
//        this.numberOfBookings++;
//        this.bookings = newBookingsArray;
//        return newbooking.getBookingId();
//    }
    public Booking specifyGuestsAndDates() {
        Scanner terminalInput = new Scanner(System.in);
        Booking booking = new Booking();
        try {
            booking.setNumberOfGuests(specifyGuests(terminalInput));
            booking.setEndDate( setEndDate(terminalInput));
            booking.setStartDate(setFromDate(terminalInput));
        } catch (Exception error) {
            System.out.println("Incorrect date format: " + error + ". Enter 'b' to go back.");
            terminalInput.nextLine();
            return null;
        }
        return booking;
    }
    private void saveBooking(Booking booking){

    }
    private int specifyGuests(Scanner terminal) {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Please enter the amount of guests you wish to stay with: ");
        String guests = terminal.nextLine();
        int guestNumber = Integer.parseInt(guests);
        return guestNumber;

    }

    private Date setFromDate(Scanner terminal) throws Exception {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        ;
        System.out.println("Please enter the dates you wish to stay from (DD/MM/YYYY): ");
        String date = terminal.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = formatter.parse(date);
        return startDate;
    }

    private Date setEndDate(Scanner terminal) throws Exception {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Please enter the date until you wish to stay (DD/MM/YYYY): ");
        String date = terminal.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date endDate = formatter.parse(date);
        return endDate;
    }
}

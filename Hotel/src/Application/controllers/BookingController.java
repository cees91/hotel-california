package Application.controllers;

import Application.models.Booking;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class BookingController {
    private Booking booking = new Booking();
    private Booking[] bookingsList = new Booking[100];

    public Booking getBooking() {
        return booking;
    }

    public void createBooking() {
        bookingsList[0] = new Booking();
    }

    public String showBookings() {
        StringBuilder bookings = new StringBuilder("Booking ID | Date booked | Booking start date | Booking end date | Booking payed \n");
        String bookingPayed;
        for(Booking currentValue: bookingsList) {
            if(currentValue.isBookingPayed()) {
                bookingPayed = "Yes";
            } else {
                bookingPayed = "No";
            }

            bookings.append(currentValue.getBookingId() + " | " + currentValue.getBookingDate() + " | " + currentValue.getStartDate() +
                    " | " + currentValue.getEndDate() + " | " + bookingPayed + "\n");
        }
        return bookings.toString();
    }

    public boolean specifyGuestsAndDates() {

        Scanner terminalInput = new Scanner(System.in);
        try {
            this.booking.setNumberOfGuests(specifyGuests(terminalInput));
            this.booking.setStartDate(setFromDate(terminalInput));
            this.booking.setEndDate( setEndDate(terminalInput));
        } catch (Exception error) {
            System.out.println("Incorrect date format: " + error + ". Enter 'b' to go back.");
            terminalInput.nextLine();
            return false;
        }
        return true;
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

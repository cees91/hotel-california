package Application.controllers;

import Application.models.Booking;
import Application.models.User;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookingController {
    private Booking booking;
    private List<Booking> bookingsList;

    public BookingController() {
        booking = new Booking();
        bookingsList = new ArrayList<>();
    }

    public Booking getBooking() {
        return booking;
    }

    // searches for a booking in the registered list, returns a booking if it can find one, it returns null when not
    public Booking getBookingById(String id) {
        for(Booking currentValue : bookingsList) {
            if(currentValue.getBookingId().equals(id)) {
                return currentValue;
            }
        }
        return null;
    }

    public void createBooking(int numberOfGuest, User headBooker, Date startDate, Date endDate) {
        bookingsList.add(new Booking(headBooker, numberOfGuest, startDate, endDate));
    }

    public String showBookings() {
        StringBuilder bookings = new StringBuilder("Booking ID \t\t\t\t\t\t\t\t| Date booked \t\t\t\t\t\t|" +
                " Booking start date \t\t\t\t| Booking end date \t\t\t\t\t| Booking payed \n");
        String bookingPayed;

        for (Booking currentValue : bookingsList) {
            //check if position is actually occupied
            if (currentValue == null) {
                continue;
            }

            if (currentValue.isBookingPayed()) {
                bookingPayed = "Yes";
            } else {
                bookingPayed = "No";
            }

            bookings.append(currentValue.getBookingId()).append( " \t| ").append(currentValue.getBookingDate()).append(" \t| ")
                    .append(currentValue.getStartDate()).append(" \t| ").append(currentValue.getEndDate()).append(" \t| ")
                    .append(bookingPayed).append("\n");
        }
        return bookings.toString();
    }


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

package Application.controllers;

import Application.models.Booking;

public class BookingController {

    private Booking[] bookingsList = new Booking[100];

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

}

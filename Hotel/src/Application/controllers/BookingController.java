package Application.controllers;

import Application.models.Booking;
import Application.models.Guest;
import Application.models.User;

import Application.repository.BookingRepository;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This is the Booking controller.
 * It can be used to find bookings, show a list of bookings and update values in the bookings.
 */
public class BookingController {
    /**
     * searches for a booking in the registered list
     * @param name the Username of the headbooker
     * @return the {@link Booking} or null, returns a booking when successful, null when not
     * TODO don't return null, throw an exception
     */
    public Booking getBookingFromRepository(String name) {
        List<Booking> bookingsList = BookingRepository.getInstance().getBookings();

        for(Booking currentValue : bookingsList) {
            // see if the given name matches the booking name
            if(currentValue.getHeadBooker().getUserName().equals(name)) {
                return currentValue;
            }
        }
        return null;
    }

    /**
     * searches for a booking in the registered list
     * @param id the ID of the headbooker
     * @return the {@link Booking} or null, returns a booking when successful, null when not
     * TODO don't return null, throw an exception
     */
    public Booking getBookingFromRepository(String id) {
        List<Booking> bookingsList = BookingRepository.getInstance().getBookings();

        for(Booking currentValue : bookingsList) {
            // get the booking id from the CSV, should be in the first column(column 0)
            if(currentValue.getBookingId().equals(id)) {
                return currentValue;
            }
        }
        return null;
    }

    /**
     * searches for a booking in the registered list
     * @param email the email of the headbooker
     * @return the {@link Booking} or null, returns a booking when successful, null when not
     * TODO don't return null, throw an exception
     */
    public Booking getBookingFromRepository(String email) {
        List<Booking> bookingsList = BookingRepository.getInstance().getBookings();

        for(Booking currentValue : bookingsList) {
            // get the email of the user from the current booking, and check if it's the same
            if(((Guest)currentValue.getHeadBooker()).getEmailAddress().equals(email)) {
                return currentValue;
            }
        }
        return null;
    }

    /**
     * returns the entire list of bookings in a nice string format
     * @return a formatted string containing all the bookings
     */
    public String showBookings() {
        StringBuilder bookings = new StringBuilder("Booking ID \t\t\t\t\t\t\t\t| Date booked \t\t\t\t\t\t|" +
                " Booking start date \t\t\t\t| Booking end date \t\t\t\t\t| Booking payed \n");
        List<Booking> bookingsList = BookingRepository.getInstance().getBookings();

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
    public void createAndSaveBooking(Booking booking){
        User guest = login();
        setUserDetails(booking, guest);
        saveBooking(booking);
    }

    private User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("User name: ");
        String userName = scanner.nextLine();
        System.out.println("Enter password: ");
        String enteredPassword = scanner.nextLine();
        User user = new User(userName, enteredPassword);
        return user;
    }
    private void setUserDetails(Booking booking, User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();
        System.out.println("houseNumber: ");
        String houseNumber = scanner.nextLine();
        System.out.println("Postcode: ");
        String postcode = scanner.nextLine();
        System.out.println("City: ");
        String city = scanner.nextLine();
        System.out.println("country: ");
        String country = scanner.nextLine();
        System.out.println("Email address: ");
        String emailAddress = scanner.nextLine();
        System.out.println("Telephone number: ");
        String phoneNumber = scanner.nextLine();

        Guest guest = new Guest(user, firstName, lastName, phoneNumber, address, houseNumber, postcode, city, country, emailAddress);
        booking.setHeadBooker(guest);
    }
    private void saveBooking(Booking booking) {
        BookingRepository bookingRepo = BookingRepository.getInstance();
        bookingRepo.saveBooking(booking);
    }
}

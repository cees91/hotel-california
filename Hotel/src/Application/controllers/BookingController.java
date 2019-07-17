package Application.controllers;

import Application.Interfaces.SaveBooking;
import Application.models.Booking;
import Application.models.Guest;
import Application.models.User;
import Application.utils.CSVReader;
import Application.utils.CSVWriter;
import Application.utils.DBSaver;

import java.text.SimpleDateFormat;
import java.util.*;

public class BookingController {

    // searches for a booking in the registered list, returns a booking if it can find one, it returns null when not
    public Booking getBookingById(String id) {
        CSVReader reader = new CSVReader();

        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + "/bookings.csv";

        // get the bookings from the CSV
         ArrayList<List<String>> bookingsList = reader.CSVParser(filePath);

        for(List<String> currentValue : bookingsList) {
            // get the booking id from the CSV, should be in the first column(column 0)
            if(currentValue.get(0) == id) {
                return bookingFromStringList(currentValue);
            }
        }
        return null;
    }

    public Booking bookingFromStringList(List<String> bookingRow) {
        Booking booking = new Booking();

//        bookingColumns[0] = booking.getBookingId();
//        bookingColumns[1] = Integer.toString(booking.getNumberOfGuests());
//        bookingColumns[2] = getDateAsString(booking.getStartDate());
//        bookingColumns[3] = getDateAsString(booking.getEndDate());
//        bookingColumns[4] = Integer.toString(booking.getBookedRooms().length);
        return booking;
    }

    public String showBookings() {
        StringBuilder bookings = new StringBuilder("Booking ID \t\t\t\t\t\t\t\t| Date booked \t\t\t\t\t\t|" +
                " Booking start date \t\t\t\t| Booking end date \t\t\t\t\t| Booking payed \n");
//        String bookingPayed;
//
//        for (Booking currentValue : bookingsList) {
//            //check if position is actually occupied
//            if (currentValue == null) {
//                continue;
//            }
//
//            if (currentValue.isBookingPayed()) {
//                bookingPayed = "Yes";
//            } else {
//                bookingPayed = "No";
//            }
//
//            bookings.append(currentValue.getBookingId()).append( " \t| ").append(currentValue.getBookingDate()).append(" \t| ")
//                    .append(currentValue.getStartDate()).append(" \t| ").append(currentValue.getEndDate()).append(" \t| ")
//                    .append(bookingPayed).append("\n");
//        }
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
    public void createAndSaveBooking(Booking booking){
        User guest = login();
        setUserDetails(booking, guest);
        saveBooking(booking,"csv");
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
        Guest guest = new Guest(user, phoneNumber, address, houseNumber, postcode, city,country, emailAddress);
        booking.setHeadBooker(guest);
    }
    private void saveBooking(Booking booking, String type){
        SaveBooking saveInstance;
        if(type.equals("csv")) {
            saveInstance = new CSVWriter();
        } else{
            saveInstance = new DBSaver();
        }
        saveInstance.saveBooking(booking);
    }
}

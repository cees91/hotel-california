package Application.controllers;

import Application.models.Booking;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class BookingController {
    Booking booking;
    public String specifyGuestsAndDates() {

        Scanner terminalInput = new Scanner(System.in);
        String guests = specifyGuests(terminalInput);
        Date startDate;
        Date endDate;
        try {
            startDate = setFromDate(terminalInput);
            endDate = setEndDate(terminalInput);
        }catch(Exception error){
            System.out.println("Incorrect date format: " + error + ". Enter 'b' to go back.");
            String date = terminalInput.nextLine();

        }
//        this.booking = new Booking(guests, startDate, endDate);
        String screen = "";
        return screen;

    }

    private String specifyGuests(Scanner terminal) {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Please enter the amount of guests you wish to stay with: ");
        String guests = terminal.nextLine();
        return guests;
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

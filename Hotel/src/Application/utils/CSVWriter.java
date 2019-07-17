package Application.utils;

import Application.Interfaces.BookingSaver;
import Application.models.Booking;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CSVWriter implements BookingSaver {

    @Override
    public void saveBooking(Booking booking){
        String[] bookingColumns = new String[10];
        bookingColumns[0] = booking.getBookingId();
        bookingColumns[1] = Integer.toString(booking.getNumberOfGuests());
        bookingColumns[2] = getDateAsString(booking.getStartDate());
        bookingColumns[3] = getDateAsString(booking.getEndDate());
        bookingColumns[4] = Integer.toString(booking.getBookedRooms().length);
        String bookingLine = String.join(",", bookingColumns);
        writeToCSV(bookingLine, "bookings.csv");
    }
    public void writeToCSV(String bookingLine, String fileName) {
        try {
            FileWriter csvWriter = new FileWriter(fileName);
            csvWriter.append(bookingLine);
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException error) {
            System.out.println("Error reading file " + error);
        }

    }

    private String getDateAsString(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        String newDate = df.format(date);
        return newDate;
    }
}

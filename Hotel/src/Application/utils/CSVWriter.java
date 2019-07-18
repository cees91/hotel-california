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
        String bookingLine = createColumns(booking);
        writeSingleLineToCSV(bookingLine, "bookings.csv");
    }
    private String createColumns(Booking booking){
        String[] bookingColumns = new String[10];
        bookingColumns[0] = booking.getBookingId();
        bookingColumns[1] = Integer.toString(booking.getNumberOfGuests());
        bookingColumns[2] = getDateAsString(booking.getStartDate());
        bookingColumns[3] = getDateAsString(booking.getEndDate());
        bookingColumns[4] = Integer.toString(booking.getBookedRooms().length);
        String bookingLine = String.join(",", bookingColumns);
        return bookingLine;
    }
    public void writeSingleLineToCSV(String bookingLine, String fileName) {
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
    public void writeMultipleLinesToCSV(Booking[] bookingLines, String fileName) throws IOException{
        FileWriter csvWriter = new FileWriter(fileName);
        String currentLine;
        for(Booking currentBooking: bookingLines){
            currentLine = createColumns(currentBooking);
            csvWriter.append(currentLine);
        }
        csvWriter.flush();
        csvWriter.close();
    }

    private String getDateAsString(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        String newDate = df.format(date);
        return newDate;
    }
}

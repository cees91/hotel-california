package Application.utils;

import Application.Interfaces.BookingSaver;
import Application.models.Booking;

import java.io.*;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CSVWriter implements BookingSaver {

    @Override
    public void saveBooking(Booking booking){
        String bookingLine = createColumns(booking);
        writeSingleLineToCSV(bookingLine, "bookings.csv");
    }
    public void removeBooking(int index){
        try {
            BufferedReader br = new BufferedReader(new FileReader("bookings.csv"));
            ArrayList<String> csvLines = new ArrayList<>();
            String line = "";
            int iterator = 0;
            try {
                FileWriter csvWriter = new FileWriter("bookings.csv");
                while ((line = br.readLine()) != null) {
                    line = br.readLine();
                    if (iterator != index) {
                        csvWriter.append(line);
                        iterator++;
                    } else {
                        iterator++;
                    }
                }
                csvWriter.flush();
                csvWriter.close();
            }catch(IOException e){
                System.out.println(e);
            }
        }catch(FileNotFoundException error){
            System.out.println(error);
        }

    }
    private String createColumns(Booking booking){
        String[] bookingColumns = new String[7];
        bookingColumns[0] = booking.getBookingId();
        bookingColumns[1] = Integer.toString(booking.getNumberOfGuests());
        bookingColumns[2] = getDateAsString(booking.getStartDate());
        bookingColumns[3] = getDateAsString(booking.getEndDate());
        bookingColumns[4] = Integer.toString(booking.getBookedRooms().length);
        bookingColumns[5] = booking.getHeadBooker().getLastName();
        bookingColumns[6] = booking.getHeadBooker().getEmailAddress();
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
    public void saveBookings(ArrayList<Booking> bookingLines){
        try {
            FileWriter csvWriter = new FileWriter("bookings.csv");
            String currentLine;
            for (Booking currentBooking : bookingLines) {
                currentLine = createColumns(currentBooking);
                csvWriter.append(currentLine);
                csvWriter.append("\n");

            }
            csvWriter.flush();
            csvWriter.close();
        }catch(IOException error){
            System.out.println(error);
        }
    }

    private String getDateAsString(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        String newDate = df.format(date);
        return newDate;
    }
}

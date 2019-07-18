package Application.utils;

import Application.models.Booking

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingCSVReader {
    private String filePath = "./Hotel/bookings.csv";

    Reader file = null;
        try

    {
        file = new FileReader(filePath);
    } catch(
    FileNotFoundException ex)

    {
        ex.printStackTrace();
    }

    String line;
    int i = 0;
        try(
    BufferedReader br = new BufferedReader(file))

    {
        Path path = Paths.get(filePath);
        long lineCount = Files.lines(path).count();
        int lines = (int) lineCount;
        ArrayList<Booking> csvBooking = new ArrayList<>();
        int roomNumber;
        boolean disabled;
        int children;
    } catch(
    IOException e)

    {
        System.out.println(e.getMessage());
    }
}


}

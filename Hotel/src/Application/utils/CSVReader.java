package Application.utils;

import Application.Enums.EBedType;
import Application.Enums.ERoomType;
import Application.models.Rooms;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    public ArrayList<Rooms> csvReader() {
        try {
            Reader file = new FileReader("./Hotel/rooms.csv");
            String line;

            int i = 0;
            try (BufferedReader br = new BufferedReader(file)) {
                Path path = Paths.get("./Hotel/rooms.csv");
                long lineCount = Files.lines(path).count();
                int lines = (int) lineCount;
                ArrayList<Rooms> csvRooms = new ArrayList<>();
                int roomNumber;
                ERoomType roomType;
                int adults;
                int floor;
                EBedType bed;
                boolean disabled;
                int children;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    roomNumber = i + 1;
                    floor = Integer.parseInt(values[0]);
                    roomType = ERoomType.valueOf(values[1].trim());
                    adults = Integer.parseInt(values[2]);
                    children = Integer.parseInt(values[3]);
                    bed = EBedType.valueOf(values[4].trim()); // Single, Double bed
                    disabled = values.length > 5 && values[5] == "yes";
                    csvRooms.add(new Rooms(roomNumber, floor, roomType, adults, children, bed, disabled));
                    i++;
                }
                return csvRooms;

            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<List<String>> CSVParser(String filename) {
         ArrayList<List<String>> parsedFile = new ArrayList<>();
        try {
            Reader file = new FileReader(filename);
            String line;

            try (BufferedReader br = new BufferedReader(file)) {
                while ((line = br.readLine()) != null) {
                    parsedFile.add(Arrays.asList(line.split(";")));
                }
                return parsedFile;

            } catch (IOException e) {
                System.out.println(e.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}

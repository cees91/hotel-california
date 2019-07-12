package Application.utils;

import Application.Enums.EBedType;
import Application.Enums.ERoomType;
import Application.models.Rooms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVReader {
    public Rooms[] csvReader() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("rooms.csv"));
            String line;

            int i = 0;
            try {
                Path path = Paths.get("rooms.csv");
                long lineCount = Files.lines(path).count();
                int lines = (int) lineCount;
                Rooms[] csvRooms = new Rooms[lines];
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
                    csvRooms[i] = new Rooms(roomNumber, floor, roomType, adults, children, bed, disabled);
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
}

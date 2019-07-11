package hotel;

import com.sun.xml.internal.ws.commons.xmlutil.Converter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Hotel {
    Rooms[] rooms;
    public Hotel (){
        this.rooms = readCSVFile();


    }
    private Rooms[] readCSVFile(){
        try  {
            BufferedReader br = new BufferedReader(new FileReader("rooms.csv"));
            String line;

            int i = 0;
            try {
                Path path = Paths.get("rooms.csv");
                long lineCount = Files.lines(path).count();
                int lines = (int) lineCount;
                Rooms[] csvRooms = new Rooms [lines];
                int roomNumber;
                RoomType roomType;
                int adults;
                int floor;
                BedType bed;
                boolean disabled;
                int children;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    roomNumber = i+1;
                    floor = Integer.parseInt(values[0]);
                    roomType = RoomType.valueOf(values[1].trim());
                    adults = Integer.parseInt(values[2]);
                    children = Integer.parseInt(values[3]);
                    bed = BedType.valueOf(values[4].trim()); // Single, Double bed
                    disabled = values.length > 5 && values[5] == "yes"? true: false;
                    csvRooms[i] = new Rooms(roomNumber, floor, roomType, adults, children, bed, disabled);
                    i++;
                }
                return csvRooms;

            } catch(IOException e){
                System.out.println(e);
            }
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
        return null;
    };

    public String showRoomTypes(){
        String types = "";
        int i = 1;
        for(RoomType currentType: RoomType.values()){
                types += i +": "+ currentType.name() + "\n";
                i++;
        }
        types += i + ": Go back \n";
        types += "q: Quit applicaiton";
        return types;
    }
    public String showRooms(RoomType type){
        String roomList = "";
        int i = 1;
        for(Rooms currentRoom: this.rooms){
            if(currentRoom.isAvailable && currentRoom.type == type){
                System.out.println(currentRoom.type);
                roomList += i + ": " + currentRoom.roomNumber + ". Price: " + currentRoom.price + ".\n";
                i++;
            }
        }
        roomList += i + ": Go back. \n";
        roomList += "q: Quit application.";
        return roomList;
    }
}

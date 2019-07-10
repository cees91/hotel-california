package hotel;

import com.sun.xml.internal.ws.commons.xmlutil.Converter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class Hotel {
    Rooms[] rooms;
    public Hotel (){
        this.rooms = readCSVFile();
    }
    private Rooms[] readCSVFile(){
        Rooms[] csvRooms = new Rooms [100];
        try  {
            BufferedReader br = new BufferedReader(new FileReader("rooms.csv"));
            String line;
            int i = 0;
            try {
                int roomNumber;
                RoomType roomType;
                int adults;
                int floor;
                BedType bed;
                boolean disabled;
                int children;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    roomNumber = i;
                    floor = Integer.parseInt(values[0]);
                    roomType = RoomType.valueOf(values[1].trim());
                    adults = Integer.parseInt(values[2]);
                    children = Integer.parseInt(values[3]);
                    bed = BedType.valueOf(values[4].trim()); // Single, Double bed
                    disabled = values.length > 5 && values[5] == "yes"? true: false;
                    csvRooms[i] = new Rooms(roomNumber, floor, roomType, adults, children, bed, disabled);
                    i++;
                }
            } catch(IOException e){
                System.out.println(e);
            }
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
        return csvRooms;
    };

    public void stringify() {
        for(Rooms room: this.rooms)
        {
            System.out.println("room: " + room.roomNumber +", type: "+ room.bedType);
        }
    }
//    public Array showRoomTypes(){
//
//    }
//    public String showRooms(EType type){
//        String roomList = "";
//        int i = 1;
//        for(Rooms currentRoom: rooms){
//            if(currentRoom.isAvailable && currentRoom.type == type){
//                roomList += i + ": " + currentRoom.roomNumber + ". Price: " + currentRoom.price + ".\n";
//                i++;
//            }
//        }
//        roomList += i + ": Go back. \n";
//        roomList += "q: Quit application.";
//        return roomList;
//    }
}

package hotel;

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
                String roomNumber;
                String price;
                String roomType;
                String type;
                String adults;
                String floor;
                String bed;
                String disabled;
                String children;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    roomNumber = Integer.toString(i +1);
                    floor =values[0];
                    type = values[1];
                    adults = values[2];
                    children = values[3];
                    bed = values[4];
                    disabled = values[5];
                    csvRooms[i] = new Rooms(roomNumber, floor, type, adults, children, bed, disabled);
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
    public Array showRoomTypes(){

    }
    public String showRooms(EType type){
        String roomList = "";
        int i = 1;
        for(Rooms currentRoom: rooms){
            if(currentRoom.isAvailable && currentRoom.type == type){
                roomList += i + ": " + currentRoom.roomNumber + ". Price: " + currentRoom.price + ".\n";
                i++;
            }
        }
        roomList += i + ": Go back. \n";
        roomList += "q: Quit application.";
        return roomList;
    }
}

package hotel;

import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import utils.CSVReader;

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
        CSVReader reader = new CSVReader();
        Rooms[] csvRooms = reader.csvReader();
        return csvRooms;
    };

    public String showRoomTypes(){
        String types = "";
        int i = 1;
        for(RoomType currentType: RoomType.values()){
                types += i +": "+ currentType.name() + "\n";
                i++;
        }
        types += "b: Go back \n";
        types += "q: Quit applicaiton";
        return types;
    }
    public String checkRoomAvailability(RoomType type){
        String roomList = "";
        int i = 1;
        for(Rooms currentRoom: this.rooms){
            if(currentRoom.isAvailable && currentRoom.type == type){
                roomList += i + ": " + currentRoom.roomNumber + ". Price: " + currentRoom.price + ".\n";
                i++;
            }
        }
        roomList += "b: Go back. \n";
        roomList += "q: Quit application.";
        return roomList;
    }
}

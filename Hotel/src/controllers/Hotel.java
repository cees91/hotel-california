package controllers;

import Enums.RoomType;
import models.Rooms;
import utils.CSVReader;

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

        return types;
    }

    public String checkRoomAvailability(RoomType type){
        String roomList = "";
        int i = 1;
        for(Rooms currentRoom: this.rooms){
            if(currentRoom.isAvailable() && currentRoom.getType() == type){
                roomList += i + ": " + currentRoom.getRoomNumber() + ". Price: " + currentRoom.getPrice() + ".\n";
                i++;
            }
        }
        return roomList;
    }
}

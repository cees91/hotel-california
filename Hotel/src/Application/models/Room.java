package Application.models;

import Application.Enums.EBedType;
import Application.Enums.ERoomType;

public class Room {

    private int roomNumber;
    private int floor;
    private ERoomType type;
    private int adults;
    private int children;
    private EBedType bedType;
    private boolean isDisabled;
    private boolean isAvailable;
    private double price;

    //default constructor for testing purposes
    public Room() { }

    public Room(int roomNumber, int floor, ERoomType type, int adults, int children, EBedType bedType, boolean isDisabled) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.type = type;
        this.adults = adults;
        this.children = children;
        this.bedType = bedType;
        this.isDisabled = isDisabled;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ERoomType getType() {
        return type;
    }

    public void setType(ERoomType type) {
        this.type = type;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public EBedType getBedType() {
        return bedType;
    }

    public void setBedType(EBedType bedType) {
        this.bedType = bedType;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

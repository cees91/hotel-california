package hotel;

public class Rooms {

    int roomNumber;
    int floor;
    RoomType type;
    int adults;
    int children;
    BedType bedType;
    boolean isDisabled;
    boolean isAvailable;
    double price;

    public Rooms(int roomNumber, int floor, RoomType type, int adults, int children, BedType bedType, boolean isDisabled) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.type = type;
        this.adults = adults;
        this.children = children;
        this.bedType = bedType;
        this.isDisabled = isDisabled;
        this.isAvailable = true;
    }
}

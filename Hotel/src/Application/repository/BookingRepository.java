package Application.repository;

import Application.models.Booking;

import java.util.ArrayList;


public class BookingRepository {

    private static BookingRepository instance = null;
    private ArrayList<Booking> bookedRooms = new ArrayList<>();

    private BookingRepository() {
        //Read the CSV and bind data to bookedRooms

    }

    //CRUD operations for bookings

    /**
     * Finds and returns an arraylist of bookings. Can have null
     * @param bookings
     * @return ArrayList of bookings
     */
    private ArrayList<Booking> findBookings(ArrayList<Booking> bookings){
        ArrayList<Booking> bookingsList = new ArrayList<>();
        Booking foundBooking = null;
        for (Booking currentBooking : this.bookedRooms) {
            foundBooking = bookings.stream()                        // Convert to steam
                    .filter(x -> currentBooking.getBookingId().equals(x.getBookingId()))        // we want "jack" only
                    .findAny()
                    .orElse(null);
            if(foundBooking != null) {
                bookingsList.add(foundBooking);                                 // If 'findAny' then return found
            }
        }
        return bookingsList;
    }

    /**
     * Finds a single booking in the booking repo by UUID
     * @param booking Booking object, should have a UUID
     * @return A single booking
     */
    private Booking findBooking(Booking booking){
        Booking foundBooking = null;
        for(Booking currentBooking: this.bookedRooms){
            if(currentBooking.getBookingId().equals(booking.getBookingId())){
                foundBooking = currentBooking;
                break;
            }
        }
        return foundBooking;
    }
    public Booking findSingleBooking(Booking booking){
        Booking foundBooking = findBooking(booking);
        return foundBooking;
    }
    public ArrayList<Booking> findMultipleBookings(ArrayList<Booking> bookings){
        ArrayList<Booking> foundBookings = findBookings(bookings);
        return foundBookings;
    }
     public void deleteBooking(Booking bookingToDelete) {
        String bookingId = bookingToDelete.getBookingId();
        this.bookedRooms.remove(findBooking(bookingToDelete));
    }


    public void addBooking(Booking bookingToAdd){
        this.bookedRooms.add(bookingToAdd);

    }
    public void confirmBooking(Booking booking){

    }
    public ArrayList<Booking> getBookings(){
        return this.bookedRooms;
    }
    public static BookingRepository getInstance() {
        if (instance == null) {
            instance = new BookingRepository();
        }
        return instance;
    }
}

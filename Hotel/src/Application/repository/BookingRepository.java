package Application.repository;

import Application.models.Booking;
import Application.models.Guest;
import Application.utils.CSVReader;
import Application.utils.EnvironmentSingleton;

import java.util.ArrayList;
import java.util.List;


public class BookingRepository {

    private static BookingRepository instance = null;
    private ArrayList<Booking> bookedRooms = new ArrayList<>();
    EnvironmentSingleton singleton = EnvironmentSingleton.getInstance();

    private BookingRepository() {
        //Read the CSV and bind data to bookedRooms


    }

    //CRUD operations for bookings

    /**
     * Finds and returns an arraylist of bookings. Can have null
     *
     * @param bookings
     * @return ArrayList of bookings
     */
    private ArrayList<Booking> findBookings(ArrayList<Booking> bookings) {
        ArrayList<Booking> bookingsList = new ArrayList<>();
        Booking foundBooking = null;
        for (Booking currentBooking : this.bookedRooms) {
            foundBooking = bookings.stream()
                    .filter(x -> currentBooking.getBookingId().equals(x.getBookingId()))
                    .findAny()
                    .orElse(null);
            if (foundBooking != null) {
                bookingsList.add(foundBooking);
            }
        }
        return bookingsList;
    }

    /**
     * Finds a single booking
     * @param lastName
     * @param id
     * @return
     */
    private Booking findBooking(String lastName, String id) {
        Booking foundBooking = null;
        for (Booking currentBooking : this.bookedRooms) {
            if (currentBooking.getHeadBooker().lastName.equals(lastName) || currentBooking.getBookingId().equals(id)) {
                foundBooking =  currentBooking;
                break;
            }
        }
        return foundBooking;
    }
    private void findAndUpdate(String lastName, String id, Booking booking){
        for(Booking currentBooking: this.bookedRooms) {
            if (currentBooking.getHeadBooker().lastName.equals(lastName) || currentBooking.getBookingId().equals(id)) {
                currentBooking = booking;
            }
        }
    }
    /**
     * Finds and returns a single booking object
     * @param name name on the booking
     * @param id id of the booking
     * @return booking object
     */
    public Booking findSingleBooking(String name, String id) {
        Booking foundBooking = findBooking(name,id);
        return foundBooking;
    }

    public ArrayList<Booking> findMultipleBookings(ArrayList<Booking> bookings) {
        ArrayList<Booking> foundBookings = findBookings(bookings);
        return foundBookings;
    }

    public void create(Booking booking) {
        this.bookedRooms.add(booking);
    }
    public void update(Booking booking){
        String name = booking.getHeadBooker().lastName;
        String id = booking.getBookingId();
        findAndUpdate(name,id,booking);
    }

    public void deleteBooking(String name, String id) {
        this.bookedRooms.remove(findBooking(name,id));
    }


    public ArrayList<Booking> getBookings() {
        return this.bookedRooms;
    }

    public static BookingRepository getInstance() {
        if (instance == null) {
            instance = new BookingRepository();
        }
        return instance;
    }
}

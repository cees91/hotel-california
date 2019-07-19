package Application.repository;

import Application.Interfaces.Repository;
import Application.models.Guest;
import Application.models.User;

import java.util.ArrayList;

public class GuestRepository implements Repository<Guest> {

    private static GuestRepository instance = null;
    private ArrayList<Guest> guests = new ArrayList<>();

    private GuestRepository() {
        //Read the CSV and bind data to bookedRooms

    }

    public static GuestRepository getInstance() {
        if (instance == null) {
            instance = new GuestRepository();
        }
        return instance;
    }

    @Override
    public void create(Guest guest) {
        guest = new Guest();
        guest.setAddress(guest.getAddress());
        guest.setHouseNumber(guest.getHouseNumber());
        guest.setCity(guest.getCity());
        guest.setCountry(guest.getCountry());
        guest.setEmailAddress(guest.getEmailAddress());
        guest.setPhoneNumber(guest.getPhoneNumber());
        guest.setPostcode(guest.getPostcode());
        guest.setUserName(guest.getUserName());
        guest.setPassword(guest.getPassword());
        guests.add(guest);
    }

    @Override
    public void update(int userId) throws Exception {
        guests.get(UserRepository.getInstance().findUserIndexById(userId));

    }

    @Override
    public void remove(int userId) throws Exception {
        guests.remove(UserRepository.getInstance().findUserIndexById(userId));
    }
}

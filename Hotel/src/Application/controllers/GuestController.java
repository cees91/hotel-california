package Application.controllers;

import Application.models.Guest;
import Application.models.User;

import java.util.ArrayList;


public class GuestController extends UserController {

    static ArrayList<Guest> guests = new ArrayList<Guest>();

//create guest account
    public String createGuestUser(User user, String phoneNumber, String address, String houseNumber, String postcode, String city, String country, String emailAddress){
        Guest guest = null;
        try {
            guest = new Guest();
            guest.setAddress(address);
            guest.setHouseNumber(houseNumber);
            guest.setCity(city);
            guest.setCountry(country);
            guest.setEmailAddress(emailAddress);
            guest.setPhoneNumber(phoneNumber);
            guest.setPostcode(postcode);
            guest.setUserName(user.getUserName());
            guest.setPassword(user.getPassword());
            guests.add(guest);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + guest.getUser_id() + ")";

    }


}

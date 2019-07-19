package Application.controllers;

import Application.models.Guest;
import Application.models.User;
import Application.repository.GuestRepository;

import java.util.ArrayList;


public class GuestController extends UserController {

    static ArrayList<Guest> guests = new ArrayList<Guest>();

    //create guest account
    public void createGuest(Guest guest){
            GuestRepository.getInstance().create(guest);
    }

    // update guest account
}

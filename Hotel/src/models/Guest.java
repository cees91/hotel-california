package models;

import models.User;

public class Guest extends User {

    String customerId;
    User user;
    String phoneNumber;
    String address;
    String houseNumber;
    String postcode;
    String city;
    String country;

    public Guest(String customerId, User user, String phoneNumber, String address, String houseNumber, String postcode, String city, String country) {
        this.customerId = customerId;
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

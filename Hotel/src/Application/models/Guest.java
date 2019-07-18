package Application.models;

public class Guest extends User {

    private String customerId;
    public String firstName;
    public String lastName;
    private String phoneNumber;
    private String address;
    private String houseNumber;
    private String postcode;
    private String city;
    private String country;
    private String emailAddress;


    public Guest() {
    }

    public Guest(User user, String firstName, String lastName, String phoneNumber, String address, String houseNumber, String postcode, String city, String country, String emailAddress) {
        this.setUserName(user.getUserName());
        this.setPassword(user.getPassword());
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

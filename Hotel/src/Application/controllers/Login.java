package Application.controllers;

import Application.models.User;

import java.util.Scanner;

public class Login {

    public Login() {
    }

    Scanner scanner = new Scanner(System.in);

    public void Login(User user) {

        boolean login = true;

        while (login) {
            String usedUsername = user.getUserName();
            String usedPassword = user.getPassword();
            System.out.println("Enter your username: ");
            String inputUsername = scanner.next();
            System.out.println("Enter your password: ");
            String inputPassword = scanner.next();


            if (usedUsername.equals(inputUsername) && usedPassword.equals(inputPassword)) {
                System.out.println("You are logged in to your account.");
                login = false;
            } else {
                System.out.println("These credentials are not correct, please try again.");
            }
        }
    }
}

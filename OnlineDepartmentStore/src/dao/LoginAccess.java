package dao;

import java.util.*;
import pojo.User;

public class LoginAccess {
	
	// The properties of Login class
	private String username;
    private String password;
    private int attempts;

    // The constructor
    
    public LoginAccess() {
        this.username = "admin";
        this.password = "password";
        this.attempts = 0;
    }
	
    // Method to ask for Login
    public void startLogin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter username:");
            String inputUsername = scanner.nextLine();

            System.out.println("Enter password:");
            String inputPassword = scanner.nextLine();

            if (isValidLogin(inputUsername, inputPassword)) {
                System.out.println("Login successful!");
                break;
            } else {
                attempts++;
                System.out.println("Invalid username or password. Please try again.");
                if (attempts >= 3) {
                    System.out.println("Too many failed attempts. Exiting the program.");
                    break;
                }
            }
        }
    }

    private boolean isValidLogin(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    public static void main(String[] args) {
        LoginAccess login = new LoginAccess();
        login.startLogin();
    }
}
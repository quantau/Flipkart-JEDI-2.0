package com.flipkart.client;


import java.util.Scanner;

public class CustomerClient {
    public static Scanner scanner = new Scanner(System.in);

    public boolean customerLogin(String userName, String password) {
        System.out.println("Successfully logged in as Customer");
        customerClientMainPage();
        return true;
    }

    public void register() {
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your Phone Number");
        String phoneNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        System.out.println("Successfully REGISTERED as Customer");

        System.out.println("\t User Name: " + userName);
        System.out.println("\t email: " + email);
        System.out.println("\t PAN Number: " + phoneNumber);
        System.out.println("\t Card Number: " + cardNumber);
        customerClientMainPage();

    }

    public void customerClientMainPage() {
        System.out.println("Welcome to customer main page!!");
    }

    public void customerChangePassword(String userName,String old_password,String new_password){
        System.out.println("Successfully changed the password");
    }

}
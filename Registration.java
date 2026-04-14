/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration;

/**
 *
 * @author otlot
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registration {

    // Saving user dtails
    private static void saveUser(String username, String password, String phone) {
        try {
            FileWriter writer = new FileWriter("users.txt", true);
            writer.write(username + "," + password + "," + phone + "\n");
            writer.close();
            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.out.println("Error saving user.");
        }
    }

    // Check if phone number is valid (+27...)
    private static boolean isValidPhone(String phone) {
        if (phone.startsWith("+27") && phone.length() >= 12) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Registration ===");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        String phone;

        // Keep asking until valid phone number is entered
        while (true) {
            System.out.print("Enter phone number (+27...): ");
            phone = input.nextLine();

            if (isValidPhone(phone)) {
                break;
            } else {
                System.out.println("Invalid phone number. Must start with +27.");
            }
        }

        saveUser(username, password, phone);

        input.close();
    }
}


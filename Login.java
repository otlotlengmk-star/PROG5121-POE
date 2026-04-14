/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author otlot
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

    private static boolean checkLogin(String username, String password) {
        try {
            File file = new File("users.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] userData = line.split(",");

                String storedUser = userData[0];
                String storedPass = userData[1];

                if (storedUser.equals(username) && storedPass.equals(password)) {
                    reader.close();
                    return true;
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No users registered yet.");
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Login ===");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (checkLogin(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }

        input.close();
    }
}

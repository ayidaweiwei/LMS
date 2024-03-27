package com.library.management;

/**
 * @author zhuangweiwei
 * @version 1.0
 */

import com.library.management.service.LibrarySystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem librarySystem = new LibrarySystem();

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            String[] commands = input.split(" ");

            switch (commands[0].toLowerCase()) {
                case "register":
                    // Implement registration logic
                    break;
                case "login":
                    // Implement login logic
                    break;
                case "list":
                    // Implement list books logic
                    break;
                // Handle other commands
            }
        }
    }
}


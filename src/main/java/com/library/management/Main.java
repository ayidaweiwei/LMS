package com.library.management;

/**
 * @author zhuangweiwei
 * @version 1.0
 */

import com.library.management.service.LibrarySystem;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem librarySystem = new LibrarySystem();

        System.out.println("Welcome to the Library Management System");
        System.out.println("Available commands: register, login, add, list, borrow, return, delete, logout, exit");

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            String arguments = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "register":
                    // Expected format: register [user|admin] [username] [password]
                    String[] registerArgs = arguments.split(" ");
                    if (registerArgs.length == 3) {
                        String type = registerArgs[0];
                        String username = registerArgs[1];
                        String password = registerArgs[2];
                        System.out.println(librarySystem.register(type, username, password));
                    } else {
                        System.out.println("Invalid arguments for register.");
                    }
                    break;
                case "login":
                    // Expected format: login [username] [password]
                    String[] loginArgs = arguments.split(" ");
                    if (loginArgs.length == 2) {
                        String username = loginArgs[0];
                        String password = loginArgs[1];
                        System.out.println(librarySystem.login(username, password));
                    } else {
                        System.out.println("Invalid arguments for login.");
                    }
                    break;
                case "add":
                    // Expected format: add "[title]" "[author]" [inventory]
                    String[] addArgs = getArgs(arguments);
                    if (addArgs.length == 3) {
                        String title = addArgs[0].replace("\"", "");
                        String author = addArgs[1];
                        int inventory = Integer.parseInt(addArgs[2].replace("\"", ""));
                        System.out.println(librarySystem.addBook(title, author, inventory));
                    } else {
                        System.out.println("Invalid arguments for add.");
                    }
                    break;
                case "list":
                    System.out.println(librarySystem.listBooks());
                    break;
                case "search":
                    String[] searchArgs = getArgs(arguments);
                    if (searchArgs.length == 2) {
                        String title = searchArgs[0].replace("\"", "");
                        String author = searchArgs[1];
                        System.out.println(librarySystem.search(title, author));
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case "borrow":
                    // Expected format: borrow "[title]" "[author]"
                    String[] borrowArgs = getArgs(arguments);
                    if (borrowArgs.length == 2) {
                        String title = borrowArgs[0].replace("\"", "");
                        String author = borrowArgs[1].replace("\"", "");
                        System.out.println(librarySystem.borrowBook(title, author));
                    } else {
                        System.out.println("Invalid arguments for borrow.");
                    }
                    break;
                case "return":
                    // Expected format: return "[title]" "[author]"
                    String[] returnArgs = getArgs(arguments);
                    if (returnArgs.length == 2) {
                        String title = returnArgs[0].replace("\"", "");
                        String author = returnArgs[1].replace("\"", "");
                        System.out.println(librarySystem.returnBook(title, author));
                    } else {
                        System.out.println("Invalid arguments for return.");
                    }
                    break;
                case "delete":
                    // Expected format: delete "[title]" "[author]"
                    String[] deleteArgs = getArgs(arguments);
                    ;
                    if (deleteArgs.length == 2) {
                        String title = deleteArgs[0].replace("\"", "");
                        String author = deleteArgs[1].replace("\"", "");
                        System.out.println(librarySystem.deleteBook(title, author));
                    } else {
                        System.out.println("Invalid arguments for delete.");
                    }
                    break;
                case "logout":
                    librarySystem.logout(); // You need to implement this method in LibrarySystem
                    System.out.println("Successfully logged out.");
                    break;
                case "exit":
                    System.out.println("Exiting the Library Management System.");
                    return;
                default:
                    System.out.println("Unknown command. Please try again.");
                    break;
            }
        }
    }

    private static String[] getArgs(String arguments) {
        String[] borrowArgsSource = arguments.split(" \"|\" |\"");
        return Arrays.stream(borrowArgsSource)
                .filter(arg -> arg != null && !arg.isEmpty())
                .toArray(String[]::new);
    }
}



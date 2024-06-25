package com.library;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Print menu
            System.out.println("\nMain Menu:");
            System.out.println("[1] Add Book");
            System.out.println("[2] Remove Book");
            System.out.println("[3] Search Book by Title");
            System.out.println("[4] View All Books");
            System.out.println("[0] Exit");
            System.out.print("Enter your choice: ");

            // Get menu choice and validate if correct
            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // consume invalid input
                continue;
            }

            switch (choice) {
                // For adding book
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();

                    // catch errors in wrong input for adding books
                    try {
                        Book book = new Book(title, author, isbn);
                        library.addBook(book);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                // Remove book
                case 2:
                    if (library.getBookCount() == 0) {
                        System.out.println("The library is empty.");
                    } else {
                        System.out.print("Enter book Item ID to remove: ");
                        int itemId = -1;
                        // Catch invalid inputs
                        try {
                            itemId = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            if (itemId <= 0) {
                                throw new IllegalArgumentException("Please enter a positive integer.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid Item ID.");
                            scanner.nextLine(); // consume invalid input
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        library.removeBook(itemId);
                    }
                    break;
                // Search book by title
                case 3:

                    if (library.getBookCount() == 0) {
                        System.out.println("The library is empty.");
                    } else {
                        System.out.print("Enter book title to search: ");
                        String searchTitle = scanner.nextLine();
                        List<Book> foundBooks = library.findBooksByTitle(searchTitle);
                        if (foundBooks.isEmpty()) {
                            System.out.println("No books found with title containing: " + searchTitle);
                        } else {
                            System.out.println("Found books:");
                            for (Book book : foundBooks) {
                                System.out.println(book);
                            }
                        }
                    }
                    break;
                // Show all books
                case 4:
                    library.listBooks();
                    break;

                case 0:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

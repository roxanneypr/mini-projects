package com.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private static int nextItemId = 1;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to check if ISBN is unique
    private boolean isIsbnUnique(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return false;
            }
        }
        return true;
    }

    // Method to add a book
    public void addBook(Book book) {
        if (book.getTitle() == null || book.getTitle().isEmpty() ||
                book.getAuthor() == null || book.getAuthor().isEmpty() ||
                book.getIsbn() == null || book.getIsbn().isEmpty()) {
            return;
        }
        if (isIsbnUnique(book.getIsbn())) {
            book.setItemId(nextItemId++);
            books.add(book);
            System.out.println("Book added: " + book);
        } else {
            System.out.println("Error: A book with the same ISBN already exists.");
        }
    }

    // Method to remove a book by item ID
    public void removeBook(int itemId) {
        Book bookToRemove = findBookByItemId(itemId);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed: " + bookToRemove);
        } else {
            System.out.println("Book not found with Item ID: " + itemId);
        }
    }

    // Method to search for a book by title
    public List<Book> findBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Method to search for a book by item ID
    public Book findBookByItemId(int itemId) {
        for (Book book : books) {
            if (book.getItemId() == itemId) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Method to get the count of books
    public int getBookCount() {
        return books.size();
    }

    // Method to list all books
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.print("Listing all books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

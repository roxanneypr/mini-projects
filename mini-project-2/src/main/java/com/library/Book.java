package com.library;

public class Book extends Item {
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        super(title);
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        if (isbn == null || !isbn.matches("\\d+")) {
            throw new IllegalArgumentException("ISBN must be numeric and cannot be null or empty");
        }
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getType() {
        return "Book";
    }

    @Override
    public String toString() {
        return "\n\nItem ID: " + getItemId() +
                "\nTitle: '" + getTitle() + '\'' +
                "\nAuthor: '" + author + '\'' +
                "\nISBN: '" + isbn + '\'' +
                "\nType: '" + getType() + '\'';
    }
}

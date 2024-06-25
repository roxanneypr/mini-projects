import com.library.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBookSuccess() {
        Book book = new Book("Title1", "Author1", "123456");
        library.addBook(book);
        assertEquals(1, library.getBookCount());
    }

    @Test
    public void testAddBookFailureDueToDuplicateIsbn() {
        Book book1 = new Book("Title1", "Author1", "123456");
        Book book2 = new Book("Title2", "Author2", "123456");
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(1, library.getBookCount());
    }

    @Test
    public void testAddBookFailureDueToEmptyFields() {
        try {
            Book book = new Book("", "Author1", "123456");
            library.addBook(book);
        } catch (IllegalArgumentException e) {
            assertEquals("Title cannot be null or empty", e.getMessage());
        }
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void testRemoveBookSuccess() {
        Book book = new Book("Title1", "Author1", "123456");
        library.addBook(book);
        library.removeBook(book.getItemId());
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void testRemoveBookFailureDueToInvalidItemId() {
        Book book = new Book("Title1", "Author1", "123456");
        library.addBook(book);
        library.removeBook(999); // Invalid Item ID
        assertEquals(1, library.getBookCount());
    }

    @Test
    public void testFindBooksByTitleSuccess() {
        Book book1 = new Book("Title1", "Author1", "123456");
        Book book2 = new Book("Another Title", "Author2", "654321");
        library.addBook(book1);
        library.addBook(book2);
        List<Book> foundBooks = library.findBooksByTitle("Title");
        assertEquals(2, foundBooks.size());
    }

    @Test
    public void testFindBooksByTitleFailure() {
        Book book = new Book("Title1", "Author1", "123456");
        library.addBook(book);
        List<Book> foundBooks = library.findBooksByTitle("Nonexistent");
        assertEquals(0, foundBooks.size());
    }

    @Test
    public void testGetBookCount() {
        Book book1 = new Book("Title1", "Author1", "123456");
        Book book2 = new Book("Title2", "Author2", "654321");
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.getBookCount());
    }
}

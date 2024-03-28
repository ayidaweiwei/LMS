/**
 * @author zhuangweiwei
 * @version 1.0
 */

import com.library.management.service.LibrarySystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LibrarySystemTest {
    private LibrarySystem librarySystem;

    @BeforeEach
    void setUp() {
        librarySystem = new LibrarySystem();
    }

    @Test
    void testUserRegistration() {
        String response = librarySystem.register("user", "JohnDoe", "password123");
        assertEquals("User JohnDoe successfully registered.", response);
    }

    @Test
    void testAdminRegistration() {
        String response = librarySystem.register("admin", "AliceAdmin", "adminPass");
        assertEquals("Admin AliceAdmin successfully registered.", response);
    }

    @Test
    void testLogin() {
        librarySystem.register("user", "JaneDoe", "password123");
        String loginResponse = librarySystem.login("JaneDoe", "password123");
        assertEquals("User JaneDoe successfully logged in.", loginResponse);
    }

    @Test
    void testAddBookByAdmin() {
        librarySystem.register("admin", "BobAdmin", "admin123");
        librarySystem.login("BobAdmin", "admin123");
        String addResponse = librarySystem.addBook("Effective Java", "Joshua Bloch", 5);
        assertEquals("Book \"Effective Java\" by Joshua Bloch added successfully, inventory: 5.", addResponse);
    }

    @Test
    void testBorrowBook() {
        librarySystem.register("user", "User1", "pass1");
        librarySystem.login("User1", "pass1");
        librarySystem.register("admin", "Admin1", "pass2");
        librarySystem.login("Admin1", "pass2");
        librarySystem.addBook("The Pragmatic Programmer", "Andy Hunt and Dave Thomas", 3);
        librarySystem.login("User1", "pass1");
        String borrowResponse = librarySystem.borrowBook("The Pragmatic Programmer", "Andy Hunt and Dave Thomas");
        assertEquals("Book \"The Pragmatic Programmer\" successfully borrowed.", borrowResponse);
    }

    @Test
    void testReturnBook() {
        librarySystem.register("user", "User2", "pass3");
        librarySystem.login("User2", "pass3");
        librarySystem.register("admin", "Admin2", "pass4");
        librarySystem.login("Admin2", "pass4");


    }
}
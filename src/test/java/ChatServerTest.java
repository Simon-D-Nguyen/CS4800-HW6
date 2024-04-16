import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChatServerTest {

    private static final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @BeforeAll
    public static void setStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @AfterAll
    public static void restoreInitialStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    public void testRegisterUser() {
        //Given
        String expected = "Already a registered User" + System.lineSeparator();
        ChatServer server = new ChatServer();
        User tester = new User("tester", 0);

        //When
        server.registerUser(tester);
        server.registerUser(tester);
        String actual = out.toString();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testUnregisterUser() {
        //Given
        String expected = "Not a registered User" + System.lineSeparator();
        ChatServer server = new ChatServer();
        User tester = new User("tester", 0);

        //When
        server.unregisterUser(tester);
        String actual = out.toString();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testSendMessage() {
        //Given
        boolean expected = false;
        ChatServer server = new ChatServer();

        //When
        boolean actual = server.sendMessage(
                new Message(new User("t", 0),
                        new ArrayList<User>(),
                        "content")
        );

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testGetUserChatHistory() {
        //Given
        User alice = new User("alice", 11);
        ChatServer server = new ChatServer();
        server.registerUser(alice);
        String expected = alice.getChatHistory();


        //When
        String actual = server.getUserChatHistory(alice, alice);


        //Then
        assertEquals(expected, actual);
    }
}

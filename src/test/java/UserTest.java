import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class UserTest {

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
    public void testGetName(){
        //GIVEN
        String expected = "name";
        User test = new User("name", 0);

        //WHEN
        String actual = test.getName();

        //THEN
        assertEquals(expected, actual);

    }

    @Test
    public void testGetId(){
        //GIVEN
        int expected = 0;
        User test = new User("name", 0);

        //WHEN
        int actual = test.getId();

        //THEN
        assertEquals(expected, actual);

    }


    @Test
    public void testGetServer(){
        //GIVEN
        ChatServer expected = null;
        User test = new User("name", 0);

        //WHEN
        ChatServer actual = test.getServer();

        //THEN
        assertEquals(expected, actual);
    }


    @Test
    public void testSetServer() {
        ChatServer server = new ChatServer();
        ChatServer expected = server;
        User test = new User("name", 0);
        test.setServer(server);

        //WHEN
        ChatServer actual = test.getServer();

        //THEN
        assertEquals(expected, actual);
    }


    @Test
    public void testSendMessage() {
        //GIVEN
        User one = new User("one", 1);
        User two = new User("two", 2);
        ChatServer server = new ChatServer();
        server.registerUser(one);
        server.registerUser(two);
        ArrayList<User> recipients = new ArrayList<>();
        recipients.add(two);
        one.sendMessage(new Message(
                one,
                recipients,
                "hello"
        ));
        String expected = "";


        //WHEN
        String actual = out.toString();


        //THEN
        assertEquals(expected, actual);

    }


    @Test
    public void testOtherSendMessage() {
        //GIVEN
        User one = new User("one", 1);
        User two = new User("two", 2);
        ChatServer server = new ChatServer();
        ArrayList<User> recipients = new ArrayList<>();
        recipients.add(two);
        one.sendMessage(server, new Message(
                one,
                recipients,
                "hello"
        ));
        String expected = "";


        //WHEN
        String actual = out.toString();


        //THEN
        assertEquals(expected, actual);

    }


    @Test
    public void testGetChatHistory() {
        //GIVEN
        User one = new User("one", 1);
        User two = new User("two", 2);
        ChatServer server = new ChatServer();
        server.registerUser(one);
        server.registerUser(two);
        ArrayList<User> recipients = new ArrayList<>();
        recipients.add(two);
        one.sendMessage(new Message(
                one,
                recipients,
                "hello"
        ));
        String time = LocalDateTime.now().toString().split("\\.")[0];
        String expected = time +
                System.lineSeparator() + "\tSender: one" +
                System.lineSeparator() + "\tRecipients: two, " +
                System.lineSeparator() + "hello" +
                System.lineSeparator() + System.lineSeparator();


        //WHEN
        String actual = one.getChatHistory();


        //THEN
        assertEquals(expected, actual);

    }


    @Test
    public void testUndoLastSentMessage() {
        //GIVEN
        User one = new User("one", 1);
        User two = new User("two", 2);
        ChatServer server = new ChatServer();
        server.registerUser(one);
        server.registerUser(two);
        ArrayList<User> recipients = new ArrayList<>();
        recipients.add(two);
        one.sendMessage(new Message(
                one,
                recipients,
                "hello"
        ));
        one.sendMessage(new Message(
                one,
                recipients,
                "bye"
        ));
        String time = LocalDateTime.now().toString().split("\\.")[0];
        String expected = time +
                System.lineSeparator() + "\tSender: one" +
                System.lineSeparator() + "\tRecipients: two, " +
                System.lineSeparator() + "hello" +
                System.lineSeparator() + System.lineSeparator();


        //WHEN
        one.undoLastSentMessage();
        String actual = one.getChatHistory();


        //THEN
        assertEquals(expected, actual);
    }
}

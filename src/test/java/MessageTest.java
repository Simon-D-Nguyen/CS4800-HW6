import MomentoAndMediator.Message;
import MomentoAndMediator.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MessageTest {

    User testUser = new User("testUser", 0);


    @Test
    public void testGetSender(){
        //Given
        User expected = testUser;

        //When
        Message tester =
                new Message(testUser, new ArrayList<User>(), "test");
        User actual = tester.getSender();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testGetRecipients(){
        //Given
        User user1 = new User("one", 1);
        User[] expected = {user1};

        //When
        ArrayList<User> iDs = new ArrayList<>();
        iDs.add(user1);
        Message tester =
                new Message(testUser, iDs, "test");
        User[] actual = tester.getRecipients();

        //Then
        assertArrayEquals(expected, actual);
    }


    @Test
    public void testGetTimestamp(){
        //Given
        String expected = LocalDateTime.now().toString().split("\\.")[0];

        //When
        Message tester =
                new Message(testUser, new ArrayList<User>(), "test");
        String actual = tester.getTimestamp();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testGetContent() {
        //Given
        String expected = "test";

        //When
        Message tester =
                new Message(testUser, new ArrayList<User>(), "test");
        String actual = tester.getContent();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testToString() {
        //Given
        String time = LocalDateTime.now().toString().split("\\.")[0];
        String expected = time +
                System.lineSeparator() + "\tSender: testUser" +
                System.lineSeparator() + "\tRecipients:" +
                System.lineSeparator() + "test";

        //When
        Message tester =
                new Message(testUser, new ArrayList<User>(), "test");
        String actual = tester.toString();

        //Then
        assertEquals(expected, actual);
    }

}

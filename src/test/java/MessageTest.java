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
        int expected = 0;

        //When
        Message tester =
                new Message(testUser, new ArrayList<Integer>(), "test");
        int actual = tester.getSender();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testGetRecipients(){
        //Given
        Integer[] expected = {1, 2};

        //When
        ArrayList<Integer> iDs = new ArrayList<>();
        iDs.add(1);
        iDs.add(2);
        Message tester =
                new Message(testUser, iDs, "test");
        Integer[] actual = tester.getRecipients();

        //Then
        assertArrayEquals(expected, actual);
    }


    @Test
    public void testGetTimestamp(){
        //Given
        String expected = LocalDateTime.now().toString().split("\\.")[0];

        //When
        Message tester =
                new Message(testUser, new ArrayList<Integer>(), "test");
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
                new Message(testUser, new ArrayList<Integer>(), "test");
        String actual = tester.getContent();

        //Then
        assertEquals(expected, actual);
    }
}

import MomentoAndMediator.ChatServer;
import MomentoAndMediator.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTest {

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
    public void testUndoLastSentMessage() {
        //Given

    }
}

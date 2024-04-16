import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;




public class MessageMomentoTest {

    @Test
    public void testGetState(){
        //Given
        Message newMessage = new Message(new User("", 0),
                new ArrayList<User>(),
                "test");
        Message expected = newMessage;


        //When
        MessageMomento momento = new MessageMomento();
        Message actual = momento.getState();


        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testSetState() {
        //Given
        Message newMessage = new Message(new User("", 0),
                new ArrayList<User>(),
                "test");
        Message expected = newMessage;


        //When
        MessageMomento momento = new MessageMomento();
        momento.setState(new Message(
                new User("test", 1),
                new ArrayList<User>(),
                "test1"
        ));
        Message actual = momento.getState();


        //Then
        assertNotEquals(expected, actual);
    }
}

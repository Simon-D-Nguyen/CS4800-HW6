import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class SearchMessagesByUserTest {

    @Test
    public void testHasNext(){
       //Given
        User alice = new User("Alice", 1);
        User bob = new User("Bob", 2);
        ChatServer server = new ChatServer();
        server.registerUser(alice);
        server.registerUser(bob);
        ArrayList<User> recipients = new ArrayList<>();
        recipients.add(bob);

        alice.sendMessage(new Message(
                alice,
                recipients,
                "hello"
        ));
        boolean expected = true;
        Iterator<Message> iter = bob.iterator(alice);


        //When
        boolean actual = iter.hasNext();


        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testNext() {
        //Given
        User alice = new User("Alice", 1);
        User bob = new User("Bob", 2);
        ChatServer server = new ChatServer();
        server.registerUser(alice);
        server.registerUser(bob);
        ArrayList<User> recipients = new ArrayList<>();
        recipients.add(bob);

        Message newMessage = new Message(
                alice,
                recipients,
                "hello"
        );
        alice.sendMessage(newMessage);
        Message expected = newMessage;
        Iterator<Message> iter = bob.iterator(alice);


        //When
        Message actual = iter.next();


        //Then
        assertEquals(expected, actual);

    }

}

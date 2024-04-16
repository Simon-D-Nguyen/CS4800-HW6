import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChatServerTest {

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
}

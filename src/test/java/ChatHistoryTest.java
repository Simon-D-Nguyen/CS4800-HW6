import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;


public class ChatHistoryTest {

    @Test
    public void testGetLatestSentMessage() {
        //Given
        User testUser = new User("", 0);
        Message message = new Message(testUser,
                new ArrayList<User>(),
                "test");

        Message expected = message;

        //When
        ChatHistory history = new ChatHistory();
        history.addMessage(null);
        history.addMessage(message);
        Message actual = history.getLatestSentMessage();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testGetChatHistory() {
        //Given
        User testUser = new User("", 0);
        String expected = "";

        //When
        ChatHistory history = new ChatHistory();
        String actual = history.getChatHistory();

        //Then
        assertEquals(expected, actual);
    }
}

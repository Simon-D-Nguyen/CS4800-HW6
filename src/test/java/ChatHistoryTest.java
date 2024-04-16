import MomentoAndMediator.MessageMomento;
import MomentoAndMediator.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import MomentoAndMediator.Message;
import MomentoAndMediator.ChatHistory;

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
}

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class ChatHistory implements IterableByUser{
    private final LinkedList<Message> history;
    private MessageMomento momento;


    public ChatHistory() {
        this.history = new LinkedList<>();
        this.momento = new MessageMomento();
    }


    public void addMessage(Message message) {
        history.addFirst(message);
    }


    public void sentMessage(Message message) {
        momento.setState(message);
        addMessage(message);
    }


    public void removeMessage(Message message) {
        history.remove(message);
    }


    public void removeLastSent() {
        Message lastSent = momento.getState();
        removeMessage(lastSent);
    }


    public Message getLatestSentMessage() {
        return history.getFirst();
    }


    public String getChatHistory() {
        String output = "";
        for (Message m : history) {
            output = output + m.toString();
        }
        return output;
    }


    public Collection<Message> getMessages(){
        return history;
    }


    @Override
    public Iterator iterator(User userToSearchWith) {
        return new SearchMessagesByUser(this, userToSearchWith);
    }
}

package MomentoAndMediator;

import java.util.LinkedList;

public class ChatHistory {
    private final LinkedList<Message> history;


    public ChatHistory() {
        this.history = new LinkedList<>();
    }


    public void addMessage(Message message) {
        history.addFirst(message);
    }


    public void removeMessage(Message message) {
        history.remove(message);
    }


    public Message getLatestSentMessage() {
        return history.getFirst();
    }
}

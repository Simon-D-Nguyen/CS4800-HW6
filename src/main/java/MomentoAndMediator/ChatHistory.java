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


    public Message getLatestMessage() {
        return history.getFirst();
    }
}

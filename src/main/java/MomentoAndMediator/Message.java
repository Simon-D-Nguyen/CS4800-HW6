package MomentoAndMediator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


public class Message {
    private User sender;
    private Collection<User> recipients;
    private LocalDateTime timestamp;
    private String content;

    public Message(User sender, Collection<User> recipients, String content){
        this.sender = sender;
        this.recipients = new ArrayList<>(recipients);
        this.content = content;

        this.timestamp = LocalDateTime.now();
    }

    public User getSender() {
        return sender;
    }


    public User[] getRecipients() {
        User[] output = new User[recipients.size()];
        return recipients.toArray(output);
    }


    public String getTimestamp() {
        String output = timestamp.toString();
        output = output.split("\\.")[0];
        return output;
    }


    public String getContent() {
        return content;
    }
}

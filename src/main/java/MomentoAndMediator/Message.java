package MomentoAndMediator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


public class Message {
    private User sender;
    private Collection<Integer> recipients;
    private LocalDateTime timestamp;
    private String content;

    public Message(User sender, Collection<Integer> recipients, String content){
        this.sender = sender;
        this.recipients = new ArrayList<>(recipients);
        this.content = content;

        this.timestamp = LocalDateTime.now();
    }

    public int getSender() {
        return sender.getId();
    }


    public Integer[] getRecipients() {
        Integer[] output = new Integer[recipients.size()];
        output = recipients.toArray(output);

        return output;
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

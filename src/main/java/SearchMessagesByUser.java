import java.util.ArrayList;
import java.util.Iterator;

public class SearchMessagesByUser implements Iterator {

    private int indexInCollection;
    private int messageCollectionSize;
    private ArrayList<Message> messages;
    User target;

    public SearchMessagesByUser(ChatHistory history, User target) {
        this.messages = new ArrayList<>(history.getMessages());
        this.indexInCollection = 0;
        this.messageCollectionSize = messages.size();
        this.target = target;
    }


    private boolean targetIsSenderOrReciever(Message message) {
        if(message.getSender() == target) {
            return true;
        }
        else {
            User[] recipients = message.getRecipients();

            for(int i = 0; i < recipients.length; i++) {
                if (target == recipients[i]){
                    return true;
                }
            }
            return false;
        }
    }


    @Override
    public boolean hasNext() {
        Message currentMessage = null;

        while(indexInCollection < messageCollectionSize) {
            currentMessage = messages.get(indexInCollection);

            if(targetIsSenderOrReciever(currentMessage)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }


    @Override
    public Object next() {
        if(hasNext()) {
            return messages.get(indexInCollection++);
        }
        else {
            return null;
        }
    }
}

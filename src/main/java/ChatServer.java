import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {

    private final ArrayList<User> users;
    private final Map<User, Collection<User>> blocklist;


    public ChatServer(){
        this.users = new ArrayList<>();
        this.blocklist = new HashMap<>();
    }


    private boolean isRegisteredUser(User user) {
        return users.contains(user);
    }


    private boolean isNotBlocked(User sendee, User blocked) {
        return !blocklist.get(sendee).contains(blocked);
    }


    public void registerUser(User user){
        if (!isRegisteredUser(user)){
            users.add(user);
            user.setServer(this);
            blocklist.put(user, new ArrayList<>());
        }
        else {
            System.out.println("Already a registered User");
        }
    }


    public void unregisterUser(User user) {
        if(isRegisteredUser(user)) {
            user.setServer(null);
            users.remove(user);
            blocklist.remove(user);
        }
        else {
            System.out.println("Not a registered User");
        }
    }


    public boolean sendMessage(Message message) {
        User sender = message.getSender();

        if(isRegisteredUser(sender)) {
            for(User recipient : message.getRecipients()) {
                if(isRegisteredUser(recipient) && isNotBlocked(recipient, sender)) {
                    recipient.receiveMessage(message);
                }
            }
            return true;
        }

        return false;
    }


    public void blockUser(User blocker, User blockee) {
        if (isRegisteredUser(blocker)) {
            blocklist.get(blocker).add(blockee);
        }
    }


    public String getUserChatHistory(User requester, User user) {
        if(isNotBlocked(user, requester)) {
            return user.getChatHistory();
        }
        else {
            return "Not available";
        }
    }
}

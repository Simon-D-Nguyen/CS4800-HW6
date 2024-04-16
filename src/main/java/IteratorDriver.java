import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDriver {

    public static void main(String[] args) {
        User alice = new User("Alice", 1);
        User bob = new User("Bob", 2);
        User cate = new User("Cate", 3);

        ChatServer server = new ChatServer();

        server.registerUser(alice);
        server.registerUser(bob);
        server.registerUser(cate);

        ArrayList<User> recipients = new ArrayList<>();
        recipients.add(bob);

        alice.sendMessage(new Message(
                alice,
                recipients,
                "hello"
        ));


        recipients.add(cate);
        alice.sendMessage(new Message(
                alice,
                recipients,
                "world"
        ));

        recipients.clear();
        recipients.add(alice);
        bob.sendMessage(new Message(
                bob,
                recipients,
                "goodbye"
        ));


        Iterator<Message> iter = bob.iterator(cate);

        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }


}

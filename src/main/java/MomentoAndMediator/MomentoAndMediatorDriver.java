package MomentoAndMediator;

import java.util.ArrayList;

public class MomentoAndMediatorDriver {

    public static void main(String[] args){
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
                "There!"
        ));

        System.out.println("---Alice's chat history");
        alice.viewChatHistory(alice);

        System.out.println("---Cate's chat history");
        alice.viewChatHistory(cate);

        System.out.println("---Bob's chat history");
        alice.viewChatHistory(cate);
        System.out.println("\n---\n");


        System.out.println("---Cate blocks Alice---");
        cate.blockUser(alice);
        alice.sendMessage(new Message(
                alice,
                recipients,
                "New there!"
        ));
        System.out.println("---Alice's chat history");
        alice.viewChatHistory(alice);
        System.out.println("---Cate's chat history");
        cate.viewChatHistory(cate);


        alice.undoLastSentMessage();
        System.out.println("--- Alice's chat history after undo");
        alice.viewChatHistory(alice);
    }
}

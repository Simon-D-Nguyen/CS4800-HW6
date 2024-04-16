package MomentoAndMediator;

public class User {
    private String name;
    private int id;
    private ChatHistory messageHistory;
    private MessageMomento momento;
    private ChatServer server;


    public User(String name, int id){
        this.name = name;
        this.id = id;
        this.server = null;
        this.momento = new MessageMomento(new Message(this, null, ""));
        this.messageHistory = new ChatHistory();
    }


    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }


    public void setServer(ChatServer server){
        this.server = server;
    }


    public ChatServer getServer(){
        return server;
    }


    private boolean hasServer() {
        return (server != null);
    }


    public void sendMessage(Message message){
        if(hasServer()){
            server.sendMessage(message);
            messageHistory.addMessage(message);
        }
        else{
            System.out.println("No server saved");
        }
    }


    public void sendMessage(ChatServer server, Message message) {
        if (server.sendMessage(message)) {
            momento.setState(message);
            messageHistory.addMessage(message);
        }
    }


    public void receiveMessage(Message message) {
        messageHistory.addMessage(message);
    }


    public void undoLastSentMessage() {
        Message lastSent = momento.getState();
        messageHistory.removeMessage(lastSent);
    }
}

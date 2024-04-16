public class User {
    private String name;
    private int id;
    private ChatHistory messageHistory;
    private ChatServer server;


    public User(String name, int id){
        this.name = name;
        this.id = id;
        this.server = null;
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
        if(hasServer() && server.sendMessage(message)){
            messageHistory.sentMessage(message);
        }
        else{
            System.out.println("No server saved");
        }
    }


    public void sendMessage(ChatServer server, Message message) {
        if (server.sendMessage(message)) {
            messageHistory.sentMessage(message);
        }
    }


    public void receiveMessage(Message message) {
        messageHistory.addMessage(message);
    }


    public void blockUser(User user){
        server.blockUser(this, user);
    }


    public void undoLastSentMessage() {
        messageHistory.removeLastSent();
    }


    public String getChatHistory(){
        return messageHistory.getChatHistory();
    }


    public void viewChatHistory(User user) {
        System.out.println(server.getUserChatHistory(this, user));
    }
}

package MomentoAndMediator;

public class User {
    private String name;
    private int id;
    private ChatServer server;


    public User(String name, int id){
        this.name = name;
        this.id = id;
        this.server = null;
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
        }
        else{
            System.out.println("No server saved");
        }
    }


    public void sendMessage(ChatServer server, Message message) {
        server.sendMessage(message);
    }


    public void recieveMessage() {
        if(hasServer()){
            //;
        }
        else {
            System.out.println("No server saved");
        }
    }


    public void undoMessage() {

    }
}

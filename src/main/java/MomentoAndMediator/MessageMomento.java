package MomentoAndMediator;

public class MessageMomento {
    private Message state;
    private String timestamp;
    private String content;

    public MessageMomento(Message message){
        this.state = message;
        this.timestamp = message.getTimestamp();
        this.content = message.getContent();
    }

    public Message getState(){
        return this.state;
    }

    public void setState(Message state){
        this.state = state;
        this.timestamp = state.getTimestamp();
        this.content = state.getContent();
    }
}

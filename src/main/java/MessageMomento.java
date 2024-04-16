public class MessageMomento {
    private Message state;
    private String timestamp;
    private String content;


    public MessageMomento(){
        this.state = null;
        this.timestamp = "";
        this.content = "";
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

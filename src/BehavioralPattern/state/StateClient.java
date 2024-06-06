package BehavioralPattern.state;

public class StateClient {
    public static void main(String[] args) {
        Document doc = new Document();
        doc.publish();
        doc.approve();
    }
    
}

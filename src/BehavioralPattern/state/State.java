package BehavioralPattern.state;

public interface State {
    void publish(Document doc);
    void approve(Document doc);
    
}

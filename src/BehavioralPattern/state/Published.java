package BehavioralPattern.state;

public class Published  implements State {
    public void publish(Document doc) {
        System.out.println("Already published.");
    }

    public void approve(Document doc) {
        System.out.println("Already approved.");
    }
}
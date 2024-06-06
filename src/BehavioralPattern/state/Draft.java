package BehavioralPattern.state;

public class Draft implements State {
    public void publish(Document doc) {
        System.out.println("Publishing draft, moving to moderation.");
        doc.setState(new Moderation());
    }

    public void approve(Document doc) {
        System.out.println("Draft cannot be approved directly.");
    }
}

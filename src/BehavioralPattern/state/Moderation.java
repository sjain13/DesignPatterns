package BehavioralPattern.state;

public class Moderation implements State {
    public void publish(Document doc) {
        System.out.println("Cannot publish from Moderation without approval.");
    }

    public void approve(Document doc) {
        System.out.println("Approving moderation, moving to published.");
        doc.setState(new Published());
    }
}

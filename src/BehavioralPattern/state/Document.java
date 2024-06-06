package BehavioralPattern.state;

class Document {
    private State state;

    public Document() {
        this.state = new Draft();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void publish() {
        state.publish(this);
    }

    public void approve() {
        state.approve(this);
    }
}
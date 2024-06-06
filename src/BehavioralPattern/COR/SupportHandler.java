package BehavioralPattern.COR;

public abstract class SupportHandler {
	protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(QueryType queryType, String message);

}

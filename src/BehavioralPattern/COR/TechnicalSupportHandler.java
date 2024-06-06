package BehavioralPattern.COR;

public class TechnicalSupportHandler extends SupportHandler {

	@Override
	public void handleRequest(QueryType queryType, String message) {
		if (queryType == QueryType.TECHNICAL) {
            System.out.println("Technical Support: Handling query - " + message);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(queryType, message);
        }
		
	}

}

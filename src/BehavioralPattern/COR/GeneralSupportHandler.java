package BehavioralPattern.COR;

public class GeneralSupportHandler extends SupportHandler {

	@Override
	public void handleRequest(QueryType queryType, String message) {
		if (queryType == QueryType.GENERAL) {
            System.out.println("General Support: Handling query - " + message);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(queryType, message);
        }
		
	}

}

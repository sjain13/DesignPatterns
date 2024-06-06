package BehavioralPattern.COR;

public class BillingSupportHandler extends SupportHandler{

	@Override
	public void handleRequest(QueryType queryType, String message) {
		if (queryType == QueryType.BILLING) {
            System.out.println("Billing Support: Handling query - " + message);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(queryType, message);
        }
		
	}

}

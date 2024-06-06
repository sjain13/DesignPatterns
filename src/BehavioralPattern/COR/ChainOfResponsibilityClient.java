package BehavioralPattern.COR;

public class ChainOfResponsibilityClient {

	public static void main(String[] args) {
		TechnicalSupportHandler technicalSupport = new TechnicalSupportHandler();
        BillingSupportHandler billingSupport = new BillingSupportHandler();
        GeneralSupportHandler generalSupport = new GeneralSupportHandler();

        technicalSupport.setNextHandler(billingSupport);
        billingSupport.setNextHandler(generalSupport);

        technicalSupport.handleRequest(QueryType.TECHNICAL, "I can't connect to the internet.");
        technicalSupport.handleRequest(QueryType.BILLING, "I have a question about my invoice.");
        technicalSupport.handleRequest(QueryType.GENERAL, "Thank you for your service.");

	}

}

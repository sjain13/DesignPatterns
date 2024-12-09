package StructuralPatterns.Facade.Example2;

// Client Code
public class FacadePatternClient {
    public static void main(String[] args) {
        HomeAutomationFacade homeAutomation = new HomeAutomationFacade();

        homeAutomation.activateEveningMode();
        homeAutomation.deactivateEveningMode();
    }
    
}

package StructuralPatterns.Facade.Example2;

// Facade: Home Automation
public class HomeAutomationFacade {
    private Lights lights;
    private AirConditioning airConditioning;
    private MusicSystem musicSystem;

    public HomeAutomationFacade() {
        this.lights = new Lights();
        this.airConditioning = new AirConditioning();
        this.musicSystem = new MusicSystem();
    }

    public void activateEveningMode() {
        System.out.println("\nActivating Evening Mode...");
        lights.turnOn();
        airConditioning.turnOn();
        musicSystem.playMusic();
    }

    public void deactivateEveningMode() {
        System.out.println("\nDeactivating Evening Mode...");
        lights.turnOff();
        airConditioning.turnOff();
        musicSystem.stopMusic();
    }
    
}

package BehavioralPattern.observer;

public class CurrentConditionsDisplay implements Observer{
    @SuppressWarnings("unused")
    private Subject weatherStation;

    public CurrentConditionsDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Current conditions: " + temperature + "F degrees and " 
                           + humidity + "% humidity");
    }
    
}

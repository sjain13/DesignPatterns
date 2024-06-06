package BehavioralPattern.observer;

public class ObserverClient {
    public static void main(String args[]){
        WeatherStation ws = new WeatherStation();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(ws);
        ws.setMeasurements(30.0f, 65f, 1013.1f);
    }
    
}

package CreationalPatterns.builder;

public class Pizza {
	private String size;
    private String crust;
    private String toppings;

    // Constructor to initialize the pizza
    public Pizza(String size, String crust, String toppings) {
        this.size = size;
        this.crust = crust;
        this.toppings = toppings;
    }

    // Setter methods
    public void setSize(String size) {
        this.size = size;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    // Display the pizza properties
    public void showPizza() {
        System.out.println("Pizza Size: " + size + ", Crust: " + crust + ", Toppings: " + toppings);
    }

}

package StructuralPatterns.CompositePattern;

public class Employee implements OrganizationComponent {
	private String name;
    private int hours;

	public Employee(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHours() {
		return hours;
	}

}

package StructuralPatterns.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationComponent {
	private String name;
    private List<OrganizationComponent> components = new ArrayList<>();
    
	public Department(String string) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHours() {
		int totalHours = 0;
        for (OrganizationComponent component : components) {
            totalHours += component.getHours();
        }
        return totalHours;
	}
	
	public void addComponent(OrganizationComponent component) {
        components.add(component);
    }

}

package StructuralPatterns.CompositePattern;

public class CompositePatternClient {
	public static void main(String[] args) {
        Department developmentDepartment = new Department("Development");
        Department marketingDepartment = new Department("Marketing");

        Employee john = new Employee("John", 40);
        Employee jane = new Employee("Jane", 35);
        Employee mike = new Employee("Mike", 30);

        developmentDepartment.addComponent(john);
        developmentDepartment.addComponent(jane);
        marketingDepartment.addComponent(mike);

        System.out.println("Total Hours in Development Department: " + developmentDepartment.getHours());
        System.out.println("Total Hours in Marketing Department: " + marketingDepartment.getHours());
    }

}

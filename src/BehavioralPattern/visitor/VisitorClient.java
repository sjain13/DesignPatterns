package BehavioralPattern.visitor;

public class VisitorClient {
	public static void main(String[] args) {
        Product food = new Food();
        Product clothing = new Clothing();
        Product electronics = new Electronics();

        DiscountVisitor holidayVisitor = new HolidayDiscountVisitor();
        DiscountVisitor clearanceVisitor = new ClearanceDiscountVisitor();

        food.accept(holidayVisitor);
        clothing.accept(clearanceVisitor);
        electronics.accept(holidayVisitor);
    }

}

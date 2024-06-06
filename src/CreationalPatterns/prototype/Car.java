package CreationalPatterns.prototype;

public abstract class Car implements Cloneable{
	protected String model;
    protected String color;

    public abstract void customize(String color, String accessories);

    @Override
    public Object clone() {
        Object clone;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
        return clone;
    }

}

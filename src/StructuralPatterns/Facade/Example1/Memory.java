package StructuralPatterns.Facade.Example1;

public class Memory {
	void load(long position, String data) {
        System.out.println("Loading " + data +" into memory at position " + position + ".");
    }

}

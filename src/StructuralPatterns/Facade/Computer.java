package StructuralPatterns.Facade;

public class Computer {
	private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();
    private OperatingSystem operatingSystem = new OperatingSystem();

    void startComputer() {
        String bootSector = hardDrive.readBootSector();
        String osData = operatingSystem.loadKernel();
        memory.load(0, bootSector);
        memory.load(1024, osData);
        cpu.initialize();
    }

}

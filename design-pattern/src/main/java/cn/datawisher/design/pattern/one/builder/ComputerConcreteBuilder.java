package cn.datawisher.design.pattern.one.builder;

/**
 * @author h407644
 * @date 2022-01-03
 */
public class ComputerConcreteBuilder implements ComputerBuilder {

    Computer computer;

    public ComputerConcreteBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildCpu() {
        System.err.println("build cpu...");
        computer.setCpu("8 core");
    }

    @Override
    public void buildMemory() {
        System.err.println("build memory...");
        computer.setMemory("16G");
    }

    @Override
    public void buildDisk() {
        System.err.println("build disk...");
        computer.setDisk("1T");
    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}

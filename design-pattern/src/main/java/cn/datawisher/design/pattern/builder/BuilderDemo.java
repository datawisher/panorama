package cn.datawisher.design.pattern.builder;

/**
 * @author h407644
 * @date 2022-01-03
 */
public class BuilderDemo {

    public static void main(String[] args) {
        ComputerDirector computerDirector = new ComputerDirector();
        ComputerBuilder computerConcreteBuilder = new ComputerConcreteBuilder();
        Computer computer = computerDirector.constructComputer(computerConcreteBuilder);
        System.err.println(computer.getCpu());
        System.err.println(computer.getMemory());
        System.err.println(computer.getDisk());
    }
}

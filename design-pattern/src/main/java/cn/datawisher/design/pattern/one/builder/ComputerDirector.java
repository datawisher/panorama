package cn.datawisher.design.pattern.one.builder;

/**
 * @author h407644
 * @date 2022-01-03
 */
public class ComputerDirector {

    public Computer constructComputer(ComputerBuilder computerBuilder) {
        computerBuilder.buildMemory();
        computerBuilder.buildCpu();
        computerBuilder.buildDisk();
        return computerBuilder.buildComputer();
    }
}

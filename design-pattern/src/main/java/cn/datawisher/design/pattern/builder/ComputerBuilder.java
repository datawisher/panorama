package cn.datawisher.design.pattern.builder;

/**
 * @author h407644
 * @date 2022-01-03
 */
public interface ComputerBuilder {

    void buildCpu();
    void buildMemory();
    void buildDisk();

    Computer buildComputer();
}

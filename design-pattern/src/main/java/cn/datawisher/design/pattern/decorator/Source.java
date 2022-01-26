package cn.datawisher.design.pattern.decorator;

/**
 * @author h407644
 * @date 2022-01-26
 */
public class Source implements Sourceable {
    @Override
    public void createComputer() {
        System.err.println("create computer by Source");
    }
}

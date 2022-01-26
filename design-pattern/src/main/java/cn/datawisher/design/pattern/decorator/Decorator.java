package cn.datawisher.design.pattern.decorator;

/**
 * @author h407644
 * @date 2022-01-26
 */
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void createComputer() {
        source.createComputer();
        System.err.println("make system");
    }
}

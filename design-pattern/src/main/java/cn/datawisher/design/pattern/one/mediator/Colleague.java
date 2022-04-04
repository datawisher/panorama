package cn.datawisher.design.pattern.one.mediator;

/**
 * @author h407644
 * @date 2022-04-04
 */
public abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract boolean operation(String message);
}

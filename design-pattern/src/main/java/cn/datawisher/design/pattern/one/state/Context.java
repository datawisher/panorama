package cn.datawisher.design.pattern.one.state;

/**
 * @author h407644
 * @date 2022-03-19
 */
public class Context {

    private AbstractState state;

    public Context(AbstractState state) {
        this.state = state;
    }

    public AbstractState getState() {
        return state;
    }

    public void setState(AbstractState state) {
        this.state = state;
    }

    public void action() {
        this.state.action(this);
    }
}

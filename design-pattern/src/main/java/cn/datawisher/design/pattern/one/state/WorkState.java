package cn.datawisher.design.pattern.one.state;

/**
 * @author h407644
 * @date 2022-03-19
 */
public class WorkState extends AbstractState {
    @Override
    public void action(Context context) {
        System.err.println("state change to work state ");
        System.err.println("work state action is meeting, design, coding ...");
    }
}

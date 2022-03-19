package cn.datawisher.design.pattern.one.state;

/**
 * @author h407644
 * @date 2022-03-19
 */
public class HolidayState extends AbstractState {
    @Override
    public void action(Context context) {
        System.err.println("state change to holiday state");
        System.err.println("holiday state actions is travel, shopping, watching television ...");
    }
}

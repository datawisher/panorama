package cn.datawisher.design.pattern.one.state;

/**
 * @author h407644
 * @date 2022-03-19
 */
public class StateDemo {

    public static void main(String[] args) {
        Context context = new Context(new WorkState());
        context.action();

        context.setState(new HolidayState());
        context.action();
    }
}

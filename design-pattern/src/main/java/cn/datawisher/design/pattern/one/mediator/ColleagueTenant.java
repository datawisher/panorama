package cn.datawisher.design.pattern.one.mediator;

/**
 * @author h407644
 * @date 2022-04-04
 */
public class ColleagueTenant extends Colleague {
    @Override
    public boolean operation(String message) {
        System.err.println("tenant receive a message from mediator: " + message);
        return true;
    }
}

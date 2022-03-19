package cn.datawisher.design.pattern.one.command;

/**
 * @author h407644
 * @date 2022-03-19
 */
public class Receiver {

    public void action(String command) {
        System.err.println("command received, now execute command");
    }
}

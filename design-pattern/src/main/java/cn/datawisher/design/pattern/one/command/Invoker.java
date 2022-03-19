package cn.datawisher.design.pattern.one.command;

/**
 * @author h407644
 * @date 2022-03-19
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void doAction(String commandMessage) {
        System.err.println("command sending ...");
        command.exe(commandMessage);
    }
}

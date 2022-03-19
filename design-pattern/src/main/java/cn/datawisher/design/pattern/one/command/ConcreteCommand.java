package cn.datawisher.design.pattern.one.command;

/**
 * @author h407644
 * @date 2022-03-19
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe(String command) {
        receiver.action(command);
    }
}

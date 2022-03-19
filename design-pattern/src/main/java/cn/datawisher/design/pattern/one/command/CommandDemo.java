package cn.datawisher.design.pattern.one.command;

/**
 * @author h407644
 * @date 2022-03-19
 */
public class CommandDemo {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        ConcreteCommand cmd = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(cmd);
        invoker.doAction("command1");
    }
}

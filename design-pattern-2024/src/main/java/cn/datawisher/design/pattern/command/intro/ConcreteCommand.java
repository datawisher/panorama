package cn.datawisher.design.pattern.command.intro;

public class ConcreteCommand extends Command {

    private Receiver receiver = new Receiver();

    @Override
    public void execute() {
        receiver.action();
    }
}

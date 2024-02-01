package cn.datawisher.design.pattern.command.example;

public class HelpCommand extends Command{
    private HelpHandler helpHandler;

    public HelpCommand() {
        helpHandler = new HelpHandler();
    }

    @Override
    public void execute() {
        helpHandler.display();
    }
}

package cn.datawisher.design.pattern.command.example;

public class MinimizeCommand extends Command {
    private WindowHandler windowHandler;

    public MinimizeCommand() {
        windowHandler = new WindowHandler();
    }

    @Override
    public void execute() {
        windowHandler.minimize();
    }
}

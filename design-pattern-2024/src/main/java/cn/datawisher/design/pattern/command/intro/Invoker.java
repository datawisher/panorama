package cn.datawisher.design.pattern.command.intro;

public class Invoker {

    private Command command;

    // 构造注入
    public Invoker(Command command) {
        this.command = command;
    }

    // Setter注入
    public void setCommand(Command command) {
        this.command = command;
    }

    // 业务方法，调用命令类的execute()方法
    public void call() {
        command.execute();
    }
}

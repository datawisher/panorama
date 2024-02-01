package cn.datawisher.design.pattern.command.example;

public class Client {

    public static void main(String[] args) {
        FBSettingWindow fbsw = new FBSettingWindow("功能键设置");

        FunctionButton fb1 = new FunctionButton("功能键1");
        FunctionButton fb2 = new FunctionButton("功能键2");

        Command command1,command2;

        command1 = new HelpCommand();
        command2 = new MinimizeCommand();

        fb1.setCommand(command1);
        fb2.setCommand(command2);

        fbsw.addFunctionButton(fb1);
        fbsw.addFunctionButton(fb2);
        fbsw.display();

        fb1.onClick();
        fb2.onClick();
    }
}

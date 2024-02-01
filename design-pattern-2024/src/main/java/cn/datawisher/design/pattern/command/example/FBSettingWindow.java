package cn.datawisher.design.pattern.command.example;

import java.util.ArrayList;

/**
 * 功能键设置窗口类
 */
public class FBSettingWindow {
    private String title;
    private ArrayList<FunctionButton> functionButtons = new ArrayList<>();

    public FBSettingWindow(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addFunctionButton(FunctionButton fb) {
        functionButtons.add(fb);
    }

    public void removeFunctionButton(FunctionButton fb) {
        functionButtons.remove(fb);
    }

    public void display() {
        System.out.println("显示窗口：" + title);
        System.out.println("显示功能键：");
        for (FunctionButton fb : functionButtons) {
            System.out.println(fb.getName());

        }
    }
}

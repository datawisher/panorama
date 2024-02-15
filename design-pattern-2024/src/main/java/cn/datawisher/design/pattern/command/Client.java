package cn.datawisher.design.pattern.command;

import cn.datawisher.design.pattern.command.editor.Editor;

public class Client {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}

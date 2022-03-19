package cn.datawisher.design.pattern.one.memento;

/**
 * @author h407644
 * @date 2022-03-19
 */
public class MementoDemo {

    public static void main(String[] args) {
        Original original = new Original("张三");
        Storage storage = new Storage(original.createMemento());
        System.err.println("original value: " + original.getValue());
        original.setValue("李四");
        System.err.println("update value: " + original.getValue());
        original.restoreMemento(storage.getMemento());
        System.err.println("restore value: " + original.getValue());
    }
}

package cn.datawisher.design.pattern.adapter;

/**
 * @author h407644
 * @date 2022-01-23
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void editWordFile() {
        System.err.println("a word file editing");
    }
}

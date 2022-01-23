package cn.datawisher.design.pattern.adapter.byInterface;

/**
 * @author h407644
 * @date 2022-01-23
 */
public class SourceSub2 extends AbstractAdapter {
    @Override
    public void editWordFile() {
        System.err.println("a word file editing");
    }
}

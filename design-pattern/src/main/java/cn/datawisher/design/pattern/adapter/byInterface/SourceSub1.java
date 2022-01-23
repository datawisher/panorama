package cn.datawisher.design.pattern.adapter.byInterface;

/**
 * @author h407644
 * @date 2022-01-23
 */
public class SourceSub1 extends AbstractAdapter {
    @Override
    public void editTextFile() {
        System.err.println("a text file editing");
    }
}

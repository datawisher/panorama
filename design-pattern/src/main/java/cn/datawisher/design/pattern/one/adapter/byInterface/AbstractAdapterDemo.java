package cn.datawisher.design.pattern.one.adapter.byInterface;

/**
 * @author h407644
 * @date 2022-01-23
 */
public class AbstractAdapterDemo {

    public static void main(String[] args) {
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();
        source1.editTextFile();
        source2.editWordFile();
    }
}

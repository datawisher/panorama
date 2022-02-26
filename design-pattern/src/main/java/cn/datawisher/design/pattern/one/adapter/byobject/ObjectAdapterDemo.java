package cn.datawisher.design.pattern.one.adapter.byobject;

import cn.datawisher.design.pattern.one.adapter.Source;
import cn.datawisher.design.pattern.one.adapter.Targetable;

/**
 * @author h407644
 * @date 2022-01-23
 */
public class ObjectAdapterDemo {
    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new ObjectAdapter(source);
        target.editTextFile();
        target.editWordFile();
    }
}

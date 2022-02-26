package cn.datawisher.design.pattern.one.adapter.byobject;

import cn.datawisher.design.pattern.one.adapter.Source;
import cn.datawisher.design.pattern.one.adapter.Targetable;

/**
 * @author h407644
 * @date 2022-01-23
 */
public class ObjectAdapter implements Targetable {

    private Source source;

    public ObjectAdapter(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void editTextFile() {
        this.source.editTextFile();
    }

    @Override
    public void editWordFile() {
        System.err.println("a word file editing");
    }
}

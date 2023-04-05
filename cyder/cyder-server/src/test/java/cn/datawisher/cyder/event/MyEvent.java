package cn.datawisher.cyder.event;

import java.util.EventObject;

public class MyEvent extends EventObject {

    private final Object content;

    public MyEvent(Object source, Object content) {
        super(source);
        this.content = content;
    }

    public Object getContent() {
        return content;
    }
}

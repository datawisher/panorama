package cn.datawisher.cyder.event;

import java.util.ArrayList;
import java.util.List;

public class MySource {

    private final List<MyListener> listeners = new ArrayList<>();

    public void addListener(MyListener listener) {
        listeners.add(listener);
    }

    public void triggerEvent(Object obj) {
        MyEvent event = new MyEvent(this, obj);
        for (MyListener listener : listeners) {
            listener.handleEvent(event);
        }
    }
}

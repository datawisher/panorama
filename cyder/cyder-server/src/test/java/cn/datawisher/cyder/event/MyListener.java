package cn.datawisher.cyder.event;

import java.util.EventListener;

public interface MyListener extends EventListener {

    void handleEvent(MyEvent event);
}

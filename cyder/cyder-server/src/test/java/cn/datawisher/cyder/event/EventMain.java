package cn.datawisher.cyder.event;

public class EventMain {

    public static void main(String[] args) {
        MySource source = new MySource();
        MyListener listener = new MyListenerImpl();
        source.addListener(listener);

        source.triggerEvent("321");
    }

}

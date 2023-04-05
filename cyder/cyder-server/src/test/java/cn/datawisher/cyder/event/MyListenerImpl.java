package cn.datawisher.cyder.event;

public class MyListenerImpl implements MyListener {
    @Override
    public void handleEvent(MyEvent event) {
        System.out.println("事件源：" + event.getSource() + "  事件内容：" + event.getContent());
    }
}

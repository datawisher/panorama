package cn.datawisher.design.pattern.one.observer;

/**
 * @author h407644
 * @date 2022-02-19
 */
public class ObserverDemo {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.add(observer);
        subject.notifyObserver("msg01");
    }
}

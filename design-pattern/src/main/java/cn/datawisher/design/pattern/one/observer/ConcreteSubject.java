package cn.datawisher.design.pattern.one.observer;

/**
 * @author h407644
 * @date 2022-02-19
 */
public class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver(String message) {
        for (Object obs : observers) {
            ((Observer)obs).dataChange(message);
        }
    }
}

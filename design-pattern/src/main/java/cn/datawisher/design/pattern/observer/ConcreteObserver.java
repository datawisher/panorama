package cn.datawisher.design.pattern.observer;

/**
 * @author h407644
 * @date 2022-02-19
 */
public class ConcreteObserver implements Observer {

    @Override
    public void dataChange(String message) {
        System.err.println("receive message: " + message);
    }
}

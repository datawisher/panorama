package cn.datawisher.design.pattern.one.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author h407644
 * @date 2022-02-19
 */
public abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public abstract void notifyObserver(String message);
}

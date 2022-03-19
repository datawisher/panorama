package cn.datawisher.design.pattern.one.memento;

/**
 * @author h407644
 * @date 2022-03-19
 */
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

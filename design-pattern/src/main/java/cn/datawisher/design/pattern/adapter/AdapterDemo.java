package cn.datawisher.design.pattern.adapter;

/**
 * @author h407644
 * @date 2022-01-23
 */
public class AdapterDemo {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.editTextFile();
        target.editWordFile();
    }
}

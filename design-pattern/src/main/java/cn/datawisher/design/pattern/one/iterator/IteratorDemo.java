package cn.datawisher.design.pattern.one.iterator;


/**
 * @author h407644
 * @date 2022-02-26
 */
public class IteratorDemo {

    public static void main(String[] args) {
        Collection collection = new ListCollection();
        collection.add("object1");
        collection.add("object3");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            System.err.println(it.next());
        }
    }
}

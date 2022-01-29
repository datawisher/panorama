package cn.datawisher.design.pattern.flyweight;

/**
 * @author h407644
 * @date 2022-01-29
 */
public class Memory {

    private int size;
    private boolean isused;
    private String id;

    public Memory(int size, boolean isused, String id) {
        this.size = size;
        this.isused = isused;
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isIsused() {
        return isused;
    }

    public void setIsused(boolean isused) {
        this.isused = isused;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

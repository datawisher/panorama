package cn.datawisher.design.pattern.builder;

/**
 * @author h407644
 * @date 2022-01-03
 */
public class Computer {

    private String cpu;
    private String memory;
    private String disk;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }
}

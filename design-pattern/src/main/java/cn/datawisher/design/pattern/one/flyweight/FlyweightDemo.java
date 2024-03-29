package cn.datawisher.design.pattern.one.flyweight;

/**
 * @author h407644
 * @date 2022-01-29
 */
public class FlyweightDemo {

    public static void main(String[] args) {
        // 首次获取内存，将创建一个内存
        Memory memory = MemoryFactory.getMemory(32);
        // 在使用后释放内存
        MemoryFactory.releaseMemory(memory.getId());
        // 重新获取内存
        MemoryFactory.getMemory(32);
    }
}

package cn.datawisher.design.pattern.one.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author h407644
 * @date 2022-01-29
 */
public class MemoryFactory {

    private static List<Memory> memoryList = new ArrayList<>();

    public static Memory getMemory(int size) {
        Memory memory = null;
        // 如果存在和需求size一样大小的并且未使用的内存块，则直接返回
        for (int i = 0; i < memoryList.size(); i++) {
            memory = memoryList.get(i);
            if (memory.getSize() == size && memory.isIsused() == false) {
                memory.setIsused(true);
                memoryList.set(i, memory);
                System.err.println("get memory from memoryList:" + memory);
                break;
            }
        }
        // 如果内存不存在，则从系统中申请新的内存返回，并将该内存加入内存对象列表中
        if (memory == null) {
            memory = new Memory(32, false, UUID.randomUUID().toString());
            System.err.println("create a new memory from system and add to memoryList:" + memory);
            memoryList.add(memory);
        }
        return memory;
    }

    // 释放内存
    public static void releaseMemory(String id) {
        for (int i = 0; i < memoryList.size(); i++) {
            Memory memory = memoryList.get(i);
            // 如果存在和需求size一样大小且未使用的内存块，则直接返回
            if (memory.getId().equals(id)) {
                memory.setIsused(false);
                memoryList.set(i, memory);
                System.err.println("release memory: " + id);
                break;
            }
        }
    }
}

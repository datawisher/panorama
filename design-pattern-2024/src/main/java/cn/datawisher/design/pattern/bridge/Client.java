package cn.datawisher.design.pattern.bridge;

import cn.datawisher.design.pattern.bridge.device.Device;
import cn.datawisher.design.pattern.bridge.device.Radio;
import cn.datawisher.design.pattern.bridge.device.Tv;
import cn.datawisher.design.pattern.bridge.remote.AdvancedRemote;
import cn.datawisher.design.pattern.bridge.remote.BasicRemote;

public class Client {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}

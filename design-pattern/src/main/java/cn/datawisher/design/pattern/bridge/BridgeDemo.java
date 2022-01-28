package cn.datawisher.design.pattern.bridge;

/**
 * @author h407644
 * @date 2022-01-28
 */
public class BridgeDemo {

    public static void main(String[] args) {

        DriverManagerBridge driverManagerBridge = new MyDriverBridge();
        driverManagerBridge.setDriver(new MySqlDriver());
        driverManagerBridge.execute();

        driverManagerBridge.setDriver(new OracleDriver());
        driverManagerBridge.execute();
    }
}

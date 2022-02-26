package cn.datawisher.design.pattern.one.bridge;

/**
 * @author h407644
 * @date 2022-01-28
 */
public abstract class DriverManagerBridge {

    private Driver driver;

    public void execute() {
        this.driver.executeSql();
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

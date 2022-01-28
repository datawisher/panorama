package cn.datawisher.design.pattern.bridge;

/**
 * @author h407644
 * @date 2022-01-28
 */
public class MyDriverBridge extends DriverManagerBridge {

    @Override
    public void execute() {
        getDriver().executeSql();
    }
}

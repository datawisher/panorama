package cn.datawisher.design.pattern.one.bridge;

/**
 * @author h407644
 * @date 2022-01-28
 */
public class MySqlDriver implements Driver {

    @Override
    public void executeSql() {
        System.err.println("execute sql by mysql driver");
    }
}

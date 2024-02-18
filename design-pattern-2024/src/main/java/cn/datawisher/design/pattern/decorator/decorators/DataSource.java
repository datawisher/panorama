package cn.datawisher.design.pattern.decorator.decorators;

public interface DataSource {
    void writeData(String data);

    String readData();
}

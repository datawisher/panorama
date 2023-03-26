package cn.datawisher.cyder.mybatisplus.generator;

import org.junit.jupiter.api.Test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

/**
 * MySQL 代码生成
 *
 * @author lanjerry
 * @since 3.5.3
 */public class MySQLGeneratorTest extends BaseGeneratorTest{

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/cyder?serverTimezone=Asia/Shanghai", "root", "123456")
            .build();

    @Test
    public void testSimple() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig().build());
        generator.global(globalConfig().build());
        generator.execute();
    }

}

package cn.datawisher.cyder.mybatisplus.generator;

import org.junit.jupiter.api.Test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

/**
 * Oracle 代码生成
 *
 * @author lanjerry
 * @since 3.5.3
 */
public class OracleGeneratorTest extends BaseGeneratorTest {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
        .Builder("jdbc:oracle:thin:@xxxx:1521:helowin", "system", "system")
        .schema("ANONYMOUS")
        .build();

    @Test
    public void testSimple() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig().build());
        generator.global(globalConfig().build());
        generator.execute();
    }
}

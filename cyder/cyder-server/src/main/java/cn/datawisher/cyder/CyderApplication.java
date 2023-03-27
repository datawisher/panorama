package cn.datawisher.cyder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CyderApplication implements ApplicationRunner {

    public static final Logger log = LoggerFactory.getLogger(CyderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CyderApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(" ====================================== ");
        log.info(" ========= Cyder 服务启动成功 ========== ");
        log.info(" ====================================== ");
    }
}

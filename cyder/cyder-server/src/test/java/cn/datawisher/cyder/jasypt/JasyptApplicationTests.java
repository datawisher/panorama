package cn.datawisher.cyder.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JasyptApplicationTests {
    @Autowired
    private StringEncryptor encryptor;
    @Test
    void contextLoads() {
        System.out.println("#######################");
        System.out.println(encryptor.encrypt("abcd"));
    }

    @Test
    void decrypt() {
        String decrypt = encryptor.decrypt("Xse5VYCKYryBMKN4uxBBHx7t0rf8sWo1w2JmPEpxecJ2jYaLdR7VFgyZJue/daw");
        System.out.println("明文：" + decrypt);
    }
}

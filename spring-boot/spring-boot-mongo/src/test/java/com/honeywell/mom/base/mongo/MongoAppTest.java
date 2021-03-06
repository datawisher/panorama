package com.honeywell.mom.base.mongo;

import com.alibaba.fastjson.JSON;
import com.honeywell.mom.base.mongo.domain.Product;
import com.honeywell.mom.base.mongo.domain.Profile;
import com.honeywell.mom.base.mongo.domain.User;
import com.honeywell.mom.base.mongo.repository.ProductRepository;
import com.honeywell.mom.base.mongo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoAppTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testInsertProduct() {
        // 创建 ProductDO 对象
        Product product = new Product();
        product.setName("邮轮");
        // 插入
        productRepository.insert(product);
        // 打印 ID
        System.out.println(product.getId());
    }

    @Test
    public void testInsertUser() {
        Profile profile = new Profile();
        profile.setGender(1);
        profile.setNickname("Adam");
        User user = new User();
        user.setUsername("家具");
        user.setProfile(profile);

        userRepository.insert(user);
    }

    @Test
    public void testMongoTemplateFindAll() {
        Set<String> collectionNames =
                mongoTemplate.getCollectionNames();
        System.out.println(collectionNames);
        List<Product> products = mongoTemplate.findAll(Product.class);
        System.out.println(JSON.toJSONString(products));
        List<User> users = mongoTemplate.findAll(User.class);
        System.out.println(JSON.toJSONString(users));
    }
}

//package com.datawisher.lcdp.redislock;
//
//import java.util.Arrays;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//
///**
// * @author h407644
// * @date 2021-06-17
// */
//public class RedisLockDemo {
//
//    @Autowired
//    public RedisTemplate redisTemplate;
//
//    /**
//     *  利用setnx加锁，存在程序异常导致无法释放锁的问题
//     */
//    public void method1() {
//        // 1.先抢占锁
//        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "123");
//        if(lock) {
//            // 2.抢占成功，执行业务
//            List<TypeEntity> typeEntityListFromDb = getDataFromDB();
//            // 3.解锁
//            redisTemplate.delete("lock");
//            return typeEntityListFromDb;
//        } else {
//            // 4.休眠一段时间
//            sleep(100);
//            // 5.抢占失败，等待锁释放
//            return getTypeEntityListByRedisDistributedLock();
//        }
//    }
//
//    /**
//     *  设置了锁过期时间, 但占锁和设置过期时间非原子操作，还是可能产生锁无法释放的问题
//     */
//    public void method2() {
//        // 1.先抢占锁
//        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "123");
//        if(lock) {
//            // 2.在 10s 以后，自动清理 lock
//            redisTemplate.expire("lock", 10, TimeUnit.SECONDS);
//            // 3.抢占成功，执行业务
//            List<TypeEntity> typeEntityListFromDb = getDataFromDB();
//            // 4.解锁
//            redisTemplate.delete("lock");
//            return typeEntityListFromDb;
//        }
//    }
//
//    /**
//     *  符合原子操作了，但无法解决实际业务操作时间大于释放锁的时间，导致前者执行完业务后，把后者的同名锁给释放了
//     */
//    public void method3() {
//        // 1.抢占锁, 在 10s 以后, 自动清理 lock
//        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "123", 10, TimeUnit.SECONDS);
//        if(lock) {
//            redisTemplate.expire("lock", 10, TimeUnit.SECONDS);
//            // 2.抢占成功，执行业务
//            List<TypeEntity> typeEntityListFromDb = getDataFromDB();
//            // 3.解锁
//            redisTemplate.delete("lock");
//            return typeEntityListFromDb;
//        }
//    }
//
//    /**
//     *  每个锁名称不同，防止同名锁被释放
//     *  但第4和5步不是原子的，同样删除的是后者的锁，并非原先自己的锁
//     *
//     */
//    public void method4() {
//        // 1.生成唯一 id
//        String uuid = UUID.randomUUID().toString();
//        // 2. 抢占锁
//        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", uuid, 10, TimeUnit.SECONDS);
//        if(lock) {
//            System.out.println("抢占成功：" + uuid);
//            // 3.抢占成功，执行业务
//            List<TypeEntity> typeEntityListFromDb = getDataFromDB();
//            // 4.获取当前锁的值
//            String lockValue = redisTemplate.opsForValue().get("lock");
//            // 5.如果锁的值和设置的值相等，则清理自己的锁
//            if(uuid.equals(lockValue)) {
//                  // 若在此时，这把锁突然不是这个客户端的，则会误解锁
//                System.out.println("清理锁：" + lockValue);
//                redisTemplate.delete("lock");
//            }
//            return typeEntityListFromDb;
//        } else {
//            System.out.println("抢占失败，等待锁释放");
//            // 4.休眠一段时间
//            sleep(100);
//            // 5.抢占失败，等待锁释放
//            return getTypeEntityListByRedisDistributedLock();
//        }
//    }
//
//    /**
//     *  脚本解锁，保证原子性
//     */
//    public void method5() {
//        String uuid = UUID.randomUUID().toString();
//        // 脚本解锁
//        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
//        redisTemplate.execute(new DefaultRedisScript<Long>(script, Long.class), Arrays.asList("lock"), uuid);
//    }
//}

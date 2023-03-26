package cn.datawisher.misc;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    public void testSubThreadExceptionCatch() {

        Thread t = new Thread(() -> {
            // 子线程执行代码
            throw new RuntimeException("子线程抛出异常");
        });
        t.start();
        try {
            t.join(); // 等待子线程执行结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Throwable ex = (Throwable) t.getUncaughtExceptionHandler(); // 获取子线程抛出的异常
        if (ex != null) {
            System.out.println("捕获子线程抛出的异常：" + ex.getMessage());
        }

    }

    @Test
    public void testSubThreadExceptionCatch2() {
        Thread t = new Thread(() -> {
            // 子线程执行代码
            throw new RuntimeException("子线程抛出异常");
        });
        t.setUncaughtExceptionHandler((t1, ex) -> {
            // 自定义异常处理器，将异常记录到日志文件中
            System.out.println("捕获子线程抛出的异常：" + ex.getMessage());
        });
        t.start();
    }
}

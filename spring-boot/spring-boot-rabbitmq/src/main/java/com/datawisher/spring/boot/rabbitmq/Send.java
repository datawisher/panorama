package com.datawisher.spring.boot.rabbitmq;

import com.datawisher.spring.boot.rabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    public static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        // 从连接获取一个通道
        Channel channel = connection.createChannel();
        // 创建队列声明
        AMQP.Queue.DeclareOk declareOk = channel
                .queueDeclare(QUEUE_NAME, false, false, false, null);

        String msg = "hello Simple";
        // exchange，队列，参数，消息字节体
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());

        System.out.println("--send msg:" + msg);

        channel.close();

        connection.close();

    }
}

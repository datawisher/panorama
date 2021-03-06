package com.datawisher.spring.boot.rabbitmq;

import com.datawisher.spring.boot.rabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        newApi();
        //oldApi();
    }

    private static void newApi() throws IOException, TimeoutException {
        // 创建连接
        Connection connection = ConnectionUtils.getConnection();
        // 创建频道
        Channel channel = connection.createChannel();
        // 队列声明  队列名，是否持久化，是否独占模式，无消息后是否自动删除，消息携带参数
        channel.queueDeclare(Send.QUEUE_NAME,false,false,false,null);
        // 定义消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override  // 事件模型，消息来了会触发该函数
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body, "utf-8");
                System.out.println("---new api recv:" + s);
            }
        };
        // 监听队列
        channel.basicConsume(Send.QUEUE_NAME,true,defaultConsumer);
    }

    // 老方法 消费者 MQ 在3。4以下 用次方法， amqp-client:4.8.3
    /*private static void oldApi() throws IOException, TimeoutException, InterruptedException {
        // 创建连接
        Connection connection = ConnectionUtils.getConnection();
        // 创建频道
        Channel channel = connection.createChannel();
        // 定义队列消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(Send.QUEUE_NAME, true, consumer);
        while (true) {
            // 发货体
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            byte[] body = delivery.getBody();
            String s = new String(body);
            System.out.println("---Recv:" + s);
        }
    }*/

}

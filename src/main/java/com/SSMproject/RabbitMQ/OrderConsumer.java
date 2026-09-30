package com.SSMproject.Consumer;

import com.SSMproject.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    //监听ORDER_QUEUE队列
    @RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE)
    public void receive(String message) {
        System.out.println("收到订单消息：" + message);
    }
}
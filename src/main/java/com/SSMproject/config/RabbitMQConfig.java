package com.SSMproject.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

     // Exchange名称
    public static final String ORDER_EXCHANGE = "order.direct";
     // Queue名称
    public static final String ORDER_QUEUE = "order.queue";
     // RoutingKey
    public static final String ORDER_ROUTING_KEY = "order";


    /**
     * 创建Direct交换机对象 精准匹配
     */
    @Bean
    public DirectExchange orderExchange() {
        return new DirectExchange(ORDER_EXCHANGE,true,false);
    }

    /**
     * 创建订单队列对象
     * 第二个参数表示队列是否持久化
     */
    @Bean
    public Queue orderQueue() {
        return new Queue(ORDER_QUEUE,true);
    }

    /**
     * 绑定exchange和queue
     * routing Key 订单发送的地址标签
     * binging key是交换机和队列之间的连接规则
     * 二者匹配才能将exchange的信息发送给Queue
     */
    @Bean
    public Binding orderBinding(
            Queue orderQueue,
            DirectExchange orderExchange) {
        return BindingBuilder
                .bind(orderQueue)
                .to(orderExchange)
                .with(ORDER_ROUTING_KEY);
    }











    /**
     * 创建Topic交换机对象 通配符匹配
     */
    @Bean
    public TopicExchange topicExchange(){return new TopicExchange("topic.exchange");}

    /**
     * 将topic交换机和队列连接
     *    * 匹配一个单词
     *    # 匹配0个或多个单词
    */
    @Bean
    public Binding orderBinding1(
            Queue orderQueue,
            TopicExchange topicExchange) {
        return BindingBuilder
                .bind(orderQueue)
                .to(topicExchange)
                .with("order.*");
    }
}
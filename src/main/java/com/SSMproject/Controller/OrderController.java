package com.SSMproject.Controller;

import com.SSMproject.RabbitMQ.OrderProducer;
import com.SSMproject.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @GetMapping("/send")
    public Result send(String message) {

        orderProducer.sendOrder(message);

        return Result.success("消息发送成功");
    }
}
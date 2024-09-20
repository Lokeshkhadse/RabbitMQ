package com.example.RabbitMQ.Consumer;

import com.example.RabbitMQ.Dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {

    //@Autowired
    //private RabbitConfiguration rabbitConfiguration;

    @Value("${rabbitmq.queue}")
    private String queue;


     //@RabbitListener(queues = "#{@rabbitConfiguration.queue}") // if using @ConfigurationProperties
    @RabbitListener(queues = "#{@environment.getProperty('rabbitmq.queue')}")
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message received from queue: " + orderStatus);
    }
}

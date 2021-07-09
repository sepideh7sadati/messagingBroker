package com.company.soha.tejarat.rabbitmq.services;

import com.company.soha.tejarat.rabbitmq.dto.UserDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    private RabbitTemplate rabbitTemplate;
    private UserService userService;

    @Autowired
    public RabbitMQSender(RabbitTemplate rabbitTemplate, UserService userService) {
        this.rabbitTemplate = rabbitTemplate;
        this.userService = userService;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public void send(UserDto user) {

        userService.createUser(user);
        rabbitTemplate.convertAndSend(exchange, routingkey, user); //method then pushes the message to exchange with the specified routingkey.

    }


}

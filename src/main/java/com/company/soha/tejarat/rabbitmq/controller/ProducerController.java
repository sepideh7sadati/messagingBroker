package com.company.soha.tejarat.rabbitmq.controller;


import com.company.soha.tejarat.rabbitmq.dto.UserDto;
import com.company.soha.tejarat.rabbitmq.services.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ProducerController {

    private RabbitMQSender rabbitMqSender;

    @Autowired
    public ProducerController(RabbitMQSender rabbitMqSender)
    {
        this.rabbitMqSender = rabbitMqSender;
    }

    @Value("${app.message}")
    private String message;

    @PostMapping("/user")
    public String publishUserDetails(@RequestBody UserDto userDto) {
        rabbitMqSender.send(userDto);
        return message;
    }

}

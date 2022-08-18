package org.charles.springboot.rabbit.controller;

import org.charles.springboot.rabbit.producer.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {
    @Autowired
    private RabbitProducer producer;

    @GetMapping("/send")
    public String send() {
        for (int i = 0; i < 1000 * 1000; i++) {
            producer.send("1-" + i);
        }
        return "send success";
    }

}

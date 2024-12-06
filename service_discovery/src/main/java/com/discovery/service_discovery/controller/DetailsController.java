package com.discovery.service_discovery.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DetailsController {

    private List<String> detailsList;
    private final RabbitTemplate rabbitTemplate;

    // Constructor initializes the list and injects RabbitTemplate
    public DetailsController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        detailsList = new ArrayList<>();
        detailsList.add("Detail 1: Spring Boot Application");
        detailsList.add("Detail 2: Simple Get Mapping Example");
        detailsList.add("Detail 3: List of Stored Details");
    }

    // Method to send message to RabbitMQ queue
    public void sendMessage(List<String> detailsList) {
        // Add some messages to detailsList
        detailsList.add("checking...1");
        detailsList.add("checking...2");
        detailsList.add("checking...3");
        detailsList.add("checking...4");
        detailsList.add("checking...5");

        // Send the list to the "detailsList" queue
        rabbitTemplate.convertAndSend("detailsList", detailsList);
    }

    // GET endpoint to retrieve the list of details
    @GetMapping("/details")
    @CircuitBreaker(name = "servicediscovery")
    public List<String> getDetails() {
        // Produce a message to RabbitMQ whenever this endpoint is called
        sendMessage(detailsList);

        // Return the details list as JSON response
        return detailsList;
    }
}

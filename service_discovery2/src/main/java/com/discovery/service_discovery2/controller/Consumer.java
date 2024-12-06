package com.discovery.service_discovery2.controller;

import com.discovery.service_discovery2.config.AppConfig;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Consumer {

    private final AppConfig appConfig;
    private List<String> consumedDetailsList;

    public Consumer(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    // Method to consume messages from the queue "detailsList"
    @RabbitListener(queues = "detailsList")
    public void consumeMessage(List<String> message) {
        // Save the consumed message to a local variable for retrieval via the API
        consumedDetailsList = message;
        System.out.println("Consumed message from detailsList: " + message);
    }

    // GET endpoint to retrieve the consumed details
    @GetMapping("/consumer")
    @CircuitBreaker(name = "servicediscovery2")
    public List<String> consumer() {
        // Return the consumed detailsList, or fallback to appConfig if no message is consumed yet
        return consumedDetailsList != null ? consumedDetailsList : appConfig.getDetails();
    }

    // Fallback method in case of circuit breaker activation
    public String fallbackMethod(Exception e) {
        return "fuse conductor nikal diye hai";
    }
}

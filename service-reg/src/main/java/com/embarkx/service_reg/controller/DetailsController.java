package com.embarkx.service_reg.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DetailsController {


    private List<String> detailsList;

    // Constructor initializes the list
    public DetailsController() {
        detailsList = new ArrayList<>();
        detailsList.add("Detail 1: Spring Boot Application");
        detailsList.add("Detail 2: Simple Get Mapping Example");
        detailsList.add("Detail 3: List of Stored Details");
    }

    // GET endpoint to retrieve the list of detail
    @GetMapping("/details")
    public List<String> getDetails() {
        return detailsList;  // Returns the list of details as JSON
    }
}


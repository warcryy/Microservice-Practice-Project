package com.discovery.service_discovery2.config;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "service-discovery")
public interface AppConfig {
    @GetMapping("/details")
    List<String> getDetails();
}

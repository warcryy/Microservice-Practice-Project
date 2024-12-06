package com.rabbitmq.consumers.Controller;

import com.rabbitmq.consumers.Dto.EmployeeDTO;
import com.rabbitmq.consumers.MessageConsumer.MessageConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/consume")
public class ConsumerController {

    public MessageConsumer messageConsumer;

    @GetMapping("/received")
    public EmployeeDTO getMessage() {
        EmployeeDTO employeeDTO = messageConsumer.receivedDetails();
        return Objects.requireNonNullElseGet(employeeDTO, () -> new EmployeeDTO("No employee", "N/A", 0));
    }

}

package com.producers.producers.Controller;


import com.producers.producers.Configs.RabbitConfigs;
import com.producers.producers.dto.EmployeeDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produce")
public class MessageProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/sent")
    public String sendEmployee(@RequestBody EmployeeDTO employeeDTO){
        rabbitTemplate.convertAndSend(RabbitConfigs.QUEUE_NAME,employeeDTO);

        return "Send Message"+employeeDTO.toString();
    }

}

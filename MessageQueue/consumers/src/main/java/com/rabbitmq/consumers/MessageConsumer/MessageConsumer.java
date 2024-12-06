package com.rabbitmq.consumers.MessageConsumer;

import com.rabbitmq.consumers.Configs.RabbitConfigs;
import com.rabbitmq.consumers.Dto.EmployeeDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private EmployeeDTO receivedDto;

    @RabbitListener(queues = RabbitConfigs.QUEUE_NAME)
    public void receiveMessage(EmployeeDTO employeeDTO){
        this.receivedDto = employeeDTO;
        System.out.println("Received Message ::" + employeeDTO.toString());
    }

    public EmployeeDTO receivedDetails() {
        return receivedDto;
    }

}

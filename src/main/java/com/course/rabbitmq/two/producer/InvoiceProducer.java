package com.course.rabbitmq.two.producer;

import com.course.rabbitmq.two.entity.InvoiceCancelledMessage;
import com.course.rabbitmq.two.entity.InvoiceCreatedMessage;
import com.course.rabbitmq.two.entity.InvoicePaidMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceProducer {

    private static final String EXCHANGE = "x.invoice";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendInvoiceCreated(InvoiceCreatedMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, "", message);
    }

    public void sendInvoicePaid(InvoicePaidMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, "", message);
    }

    public void sendInvoiceCancelled(InvoiceCancelledMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, "", message);
    }

}

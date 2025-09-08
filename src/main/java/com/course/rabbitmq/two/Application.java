package com.course.rabbitmq.two;

import com.course.rabbitmq.two.entity.InvoiceCancelledMessage;
import com.course.rabbitmq.two.producer.InvoiceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private InvoiceProducer producer;

    @Override
    public void run(String... args) {
		for (int i = 0; i < 10; i++) {
			var invoiceNumber = "INV-" + i;
			var invoiceCancelledMessage = new InvoiceCancelledMessage(
					LocalDate.now(),
					invoiceNumber,
					"InvoiceCancelled " + i);

			producer.sendInvoiceCancelled(invoiceCancelledMessage);
		}
    }
}

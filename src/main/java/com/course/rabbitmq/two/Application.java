package com.course.rabbitmq.two;

import com.course.rabbitmq.two.entity.InvoiceCreatedMessage;
import com.course.rabbitmq.two.producer.InvoiceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private InvoiceProducer producer;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 200; i++) {
            var invoiceNumber = "INV-" + (i % 60);
            var invoice = new InvoiceCreatedMessage(
                    ThreadLocalRandom.current().nextInt(1, 200),
                    LocalDate.now(),
                    "USD",
                    invoiceNumber);
            producer.sendInvoiceCreated(invoice);
        }
    }
}

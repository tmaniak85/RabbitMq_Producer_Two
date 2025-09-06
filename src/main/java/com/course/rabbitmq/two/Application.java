package com.course.rabbitmq.two;

import com.course.rabbitmq.two.entity.InvoiceCreatedMessage;
import com.course.rabbitmq.two.entity.InvoicePaidMessage;
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
		var randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(100, 200);
		var invoiceCreatedMassage = new InvoiceCreatedMessage(155.75, LocalDate.now(), "USD", randomInvoiceNumber);
		producer.sendInvoiceCreated(invoiceCreatedMassage);

		randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(200, 300);
		var randomPaymentNumber = "PAY-" + ThreadLocalRandom.current().nextInt(1000, 2000);
		var invoicePaidMessage = new InvoicePaidMessage(randomInvoiceNumber, LocalDate.now(), randomPaymentNumber);
		producer.sendInvoicePaid(invoicePaidMessage);
	}
}

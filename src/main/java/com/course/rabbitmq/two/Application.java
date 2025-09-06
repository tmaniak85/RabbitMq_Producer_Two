package com.course.rabbitmq.two;

import com.course.rabbitmq.two.producer.MultiplePrefetchProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private MultiplePrefetchProducer producer;

	@Override
	public void run(String... args) throws Exception {
		producer.simulateTransaction();
		producer.simulateScheduler();

		System.out.println("Al data sent");
	}
}

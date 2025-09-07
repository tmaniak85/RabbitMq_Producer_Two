package com.course.rabbitmq.two;

import com.course.rabbitmq.two.entity.DummyMessage;
import com.course.rabbitmq.two.producer.ReliableProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private ReliableProducer producer;

    @Override
    public void run(String... args) throws InterruptedException {
		var dummyMessage = new DummyMessage("Dummy content", 1);

		System.out.println("------------------------------------------------------------------");
		System.out.println("Calling sendDummyToInvalidExchange()");
        producer.sendDummyToInvalidExchange(dummyMessage);

		TimeUnit.SECONDS.sleep(2);

		System.out.println("------------------------------------------------------------------");
		System.out.println("Calling sendDummyWithInvalidRoutingKey()");
		producer.sendDummyWithInvalidRoutingKey(dummyMessage);
    }
}

package com.course.rabbitmq.two;

import com.course.rabbitmq.two.entity.DummyMessage;
import com.course.rabbitmq.two.producer.AnotherDummyProducer;
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
	private AnotherDummyProducer producer;

    @Override
    public void run(String... args) {
		var message = new DummyMessage("just a dummy", 1);
		producer.sendDummy(message);
    }
}

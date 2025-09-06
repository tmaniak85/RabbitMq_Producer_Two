package com.course.rabbitmq.two;

import com.course.rabbitmq.two.entity.DummyMessage;
import com.course.rabbitmq.two.producer.DummyProducer;
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
	private DummyProducer producer;

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 500; i++) {
			var dummyMessage = new DummyMessage("Content " + i, 1);

			producer.sendDummy(dummyMessage);
		}
	}
}

package com.ipartek.formacion.spring.springbootbasico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootbasicoApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("beautiful")
	private MessageRenderer beautifulRenderer;
	
	@Autowired
	@Qualifier("simple")
	private MessageRenderer simpleRenderer;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootbasicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		beautifulRenderer.render();
		simpleRenderer.render();
	}

}

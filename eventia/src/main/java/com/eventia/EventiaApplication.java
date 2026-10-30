package com.eventia;

import com.eventia.web.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventiaApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<HelloServlet> helloServlet() {
		return new ServletRegistrationBean<>(new HelloServlet(), "/hello");
	}

}

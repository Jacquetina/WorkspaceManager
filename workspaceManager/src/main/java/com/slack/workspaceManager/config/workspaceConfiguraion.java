package com.slack.workspaceManager.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClientOptions;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class workspaceConfiguraion {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
	
	@Bean(name="directQueue")
	public Queue directQueue() {
		return new Queue("directQueue");
	}
	
	@Bean(name="directExchange")
	public DirectExchange exchange() {
		return new DirectExchange("directExchange");
	}
	
	@Bean(name="directBinding")
	public Binding directBinding(DirectExchange exchange) {
		return BindingBuilder.bind(directQueue()).to(exchange).with("direct-key");
	}

}

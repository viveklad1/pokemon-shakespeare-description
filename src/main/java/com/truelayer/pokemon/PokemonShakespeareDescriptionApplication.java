package com.truelayer.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class PokemonShakespeareDescriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonShakespeareDescriptionApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder)
	{
		return restTemplateBuilder
				.setConnectTimeout(Duration.ofSeconds(20))
           .setReadTimeout(Duration.ofSeconds(20))
           .build();
	}
}

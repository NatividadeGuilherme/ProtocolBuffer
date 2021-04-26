package br.natividade.teste_protocol.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

	@Bean
	public RestTemplate defaultRestTemplate() {
		return new RestTemplate();
	}
}

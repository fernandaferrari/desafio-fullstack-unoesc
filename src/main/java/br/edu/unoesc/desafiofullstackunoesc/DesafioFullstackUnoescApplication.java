package br.edu.unoesc.desafiofullstackunoesc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DesafioFullstackUnoescApplication {

	@Bean
	public WebClient webClient(WebClient.Builder builder){
		String url = "https://api.portaldatransparencia.gov.br/api-de-dados";
		return builder.baseUrl(url).defaultHeader("chave-api-dados", "634d7ef9135b36b36ed3223f9eb6eb10").build();
	}


	public static void main(String[] args) {
		SpringApplication.run(DesafioFullstackUnoescApplication.class, args);
	}

}

package br.natividade.teste_consumer_proto.usecase;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.natividade.entrypoint.dto.ClienteBuilderGravar.ClienteGravar;
import br.natividade.entrypoint.dto.ClienteBuilderObter;
import br.natividade.entrypoint.dto.ClienteBuilderObter.ClienteObter;

@Component
public class ClienteUseCase {

	
	@Qualifier("restTemplate")
	@Autowired
	private RestTemplate restTemplate;

	public ClienteBuilderObter.ClienteObter obter() throws URISyntaxException {
		ClienteGravar clienteGravar = ClienteGravar.newBuilder().setEmail("guilherme@gmail.com")
				.setNomeCliente("Guilherme").setIdade(25)
				.setCep("03310000")
				.build();
		
		RequestEntity<ClienteGravar> request = RequestEntity.post(new URI("http://127.0.0.1:8081/cliente/criar"))
				.header("Content-Type", "application/x-protobuf")
				.body(clienteGravar);
		
		
		ResponseEntity<ClienteObter> response = restTemplate.exchange(request, ClienteObter.class);
		
		if(response.hasBody()) {
			System.out.println(response.getBody().getDataNascimento());
		}
		
		return response.getBody();
		
	}

}

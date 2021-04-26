package br.natividade.teste_consumer_proto.controller.usecase;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.natividade.entrypoint.dto.ClienteBuilderGravar;
import br.natividade.entrypoint.dto.ClienteBuilderGravar.ClienteGravar;
import br.natividade.entrypoint.dto.ClienteBuilderObter;
import br.natividade.entrypoint.dto.ClienteBuilderObter.ClienteObter;

@Component
public class ClienteUseCase {

	@Autowired
	private RestTemplate restTemplate;

	public ClienteBuilderObter.ClienteObter obter() throws URISyntaxException {
		ClienteGravar clienteGravar = ClienteGravar.newBuilder().setEmail("guilherme@gmail.com")
				.setNomeCliente("Guilherme").setIdade(25)
				.addEnderecos(ClienteBuilderGravar.Endereco.newBuilder().setNomeRua("Tosta").build()).build();
		
		RequestEntity<ClienteGravar> request = RequestEntity.post(new URI("http://localhost:8081/cliente/criar")).body(clienteGravar);
		
		
		ResponseEntity<ClienteObter> response = restTemplate.exchange(request, ClienteObter.class);
		
		System.out.println("Response reseved");
		System.out.println(response.getStatusCodeValue());
		
		if(response.hasBody()) {
			System.out.println(response.getBody().getDataNascimento());
		}
		
		return response.getBody();
		
	}

}

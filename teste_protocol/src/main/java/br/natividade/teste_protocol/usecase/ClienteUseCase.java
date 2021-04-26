package br.natividade.teste_protocol.usecase;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.natividade.teste_protocol.usecase.model.ClienteDomain;
import br.natividade.teste_protocol.usecase.model.Endereco;

@Component
public class ClienteUseCase {
	
	@Autowired
	private RestTemplate restTemplate;

	private List<ClienteDomain> clientes = new ArrayList<>();
	
	public ClienteDomain adicionar(ClienteDomain cliente) throws RestClientException, URISyntaxException {
		
//		RequestEntity<Void> request = RequestEntity.get());
		
		ResponseEntity<Endereco> endereco = restTemplate.exchange(new URI(getEnderecoApiViaCep(cliente.getCep())),
				HttpMethod.GET, null, Endereco.class);
		
		cliente.setEndereco(endereco.getBody());
		
		clientes.add(cliente);
		
		return cliente;
	}
	
	private String getEnderecoApiViaCep(String cep) {
		return "https://viacep.com.br/ws/" + cep + "/json/";
	}
}

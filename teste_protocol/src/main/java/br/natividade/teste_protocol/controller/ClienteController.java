package br.natividade.teste_protocol.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import br.natividade.entrypoint.dto.ClienteRequestBuilder.ClienteRequest;
import br.natividade.entrypoint.dto.ClienteResponseBuilder.ClienteResponse;
import br.natividade.teste_protocol.controller.mapper.ClienteMapper;
import br.natividade.teste_protocol.usecase.ClienteUseCase;
import br.natividade.teste_protocol.usecase.model.ClienteDomain;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteUseCase useCase;

	@PostMapping(value = "/criar",consumes = "application/x-protobuf", produces = "application/x-protobuf")
	public ResponseEntity<ClienteResponse> salvarCliente(@RequestBody ClienteRequest cliente) throws RestClientException, URISyntaxException{
		ClienteDomain domain = ClienteMapper.toDomain(cliente);
		
		useCase.adicionar(domain);
		
		ClienteResponse response = ClienteMapper.toResponse(domain);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}

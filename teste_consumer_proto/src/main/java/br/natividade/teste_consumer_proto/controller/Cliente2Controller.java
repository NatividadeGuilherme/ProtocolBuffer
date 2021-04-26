package br.natividade.teste_consumer_proto.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.natividade.entrypoint.dto.ClienteBuilderObter.ClienteObter;
import br.natividade.teste_consumer_proto.usecase.ClienteUseCase;

@RestController
@RequestMapping("/cliente2")
public class Cliente2Controller {

	@Autowired
	private ClienteUseCase useCase;
	
	@GetMapping("/obter")
	public ResponseEntity<ClienteObter> obter() throws URISyntaxException{
		ClienteObter clienteObtido = useCase.obter();
		
		return ResponseEntity.ok(clienteObtido);
	}
}

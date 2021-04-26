package br.natividade.teste_protocol.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.natividade.teste_protocol.usecase.model.ClienteDomain;

@Component
public class ClienteUseCase {

	private List<ClienteDomain> clientes = new ArrayList<>();
	
	public void adicionar(ClienteDomain cliente) {
		clientes.add(cliente);
	}
}

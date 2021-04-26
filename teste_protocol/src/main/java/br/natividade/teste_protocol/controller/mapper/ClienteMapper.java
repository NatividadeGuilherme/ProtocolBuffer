package br.natividade.teste_protocol.controller.mapper;

import java.time.LocalDate;

import br.natividade.entrypoint.dto.ClienteRequestBuilder.ClienteRequest;
import br.natividade.entrypoint.dto.ClienteResponseBuilder;
import br.natividade.entrypoint.dto.ClienteResponseBuilder.ClienteResponse;
import br.natividade.teste_protocol.usecase.model.ClienteDomain;

public class ClienteMapper {

	public static ClienteDomain toDomain(ClienteRequest clienteRequest) {
		ClienteDomain clienteDomain = new ClienteDomain();
		clienteDomain.setDataNascimento(LocalDate.now().toString());
		clienteDomain.setNome(clienteRequest.getNomeCliente());
		clienteDomain.setEmail(clienteRequest.getEmail());
		clienteDomain.setIdade(clienteRequest.getIdade());
		return clienteDomain;
	}
	
	public static ClienteResponse toResponse(ClienteDomain clienteDomain) {
		return ClienteResponseBuilder.ClienteResponse.newBuilder()
				.setDataNascimento(clienteDomain.getDataNascimento())
				.setEmail(clienteDomain.getEmail())
				.setNomeCliente(clienteDomain.getNome())
				.build();
	}
}

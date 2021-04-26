package br.natividade.teste_protocol.controller.mapper;

import java.time.LocalDate;

import br.natividade.entrypoint.dto.ClienteRequestBuilder;
import br.natividade.entrypoint.dto.ClienteResponseBuilder;
import br.natividade.entrypoint.dto.ClienteResponseBuilder.EnderecoCliente;
import br.natividade.teste_protocol.usecase.model.ClienteDomain;

public class ClienteMapper {

	public static ClienteDomain toDomain(ClienteRequestBuilder.ClienteRequest clienteRequest) {
		ClienteDomain clienteDomain = new ClienteDomain();
		clienteDomain.setDataNascimento(LocalDate.now().toString());
		clienteDomain.setNome(clienteRequest.getNomeCliente());
		clienteDomain.setEmail(clienteRequest.getEmail());
		clienteDomain.setIdade(clienteRequest.getIdade());
		clienteDomain.setCep(clienteRequest.getCep());

		return clienteDomain;
	}

	public static ClienteResponseBuilder.ClienteResponse toResponse(ClienteDomain clienteDomain) {
		return ClienteResponseBuilder.ClienteResponse.newBuilder().setDataNascimento(clienteDomain.getDataNascimento())
				.setEmail(clienteDomain.getEmail()).setNomeCliente(clienteDomain.getNome())
				.addEnderecos(EnderecoCliente.newBuilder().setBairro(clienteDomain.getEndereco().getBairro())
						.setCidade(clienteDomain.getEndereco().getLocalidade())
						.setLogradouro(clienteDomain.getEndereco().getLogradouro())
						.setUf(clienteDomain.getEndereco().getUf()))
				.build();
	}
}

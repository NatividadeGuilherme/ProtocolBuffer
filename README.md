# ProtocolBuffer
Exemplo de duas aplicações trafegando informações via protocoll buffer.

A aplicação teste_consumer_proto basicamente está simulando um client fazendo requisição rest para um servidor.

A aplicação teste_protocol basicamente está simulando um server-side que dado o cep passando na request, faz a consulta na API via cep e devolve para o client
o objeto cliente populado com endereço.


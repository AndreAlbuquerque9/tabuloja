package br.com.tabuloja.application.port;

import br.com.tabuloja.domain.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {
    Optional<Cliente> buscarPorCpf(String cpf);


    Cliente salvar(Cliente cliente);
}

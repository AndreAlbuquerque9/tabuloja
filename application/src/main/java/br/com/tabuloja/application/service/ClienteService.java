package br.com.tabuloja.application.service;

import br.com.tabuloja.application.port.ClienteRepositoryPort;
import br.com.tabuloja.domain.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteService(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    public Cliente cadastrar(CadastrarClienteCommand cadastrarClienteCommand) {

        if(clienteRepositoryPort.buscarPorCpf(cadastrarClienteCommand.clienteCpf()).isPresent()) {
            throw new RuntimeException("Cliente já cadastrado");
        }

        Cliente cliente = new Cliente(
                cadastrarClienteCommand.nome(),
                cadastrarClienteCommand.email(),
                cadastrarClienteCommand.clienteCpf()
        );

        return clienteRepositoryPort.salvar(cliente);
    }

    public Cliente buscarPorCpf(String cpf) {
        return clienteRepositoryPort.buscarPorCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}

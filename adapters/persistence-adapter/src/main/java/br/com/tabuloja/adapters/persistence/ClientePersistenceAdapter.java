package br.com.tabuloja.adapters.persistence;

import br.com.tabuloja.adapters.persistence.mapper.ClienteMapper;
import br.com.tabuloja.adapters.repository.ClienteRepository;
import br.com.tabuloja.application.port.ClienteRepositoryPort;
import br.com.tabuloja.domain.Cliente;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientePersistenceAdapter implements ClienteRepositoryPort {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClientePersistenceAdapter(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public Optional<Cliente> buscarPorCpf(String clienteCpf) {

        Optional<ClienteJpaEntity> entidadeOptional = clienteRepository.findByCpf(clienteCpf);

        return entidadeOptional.map(clienteMapper::paraDominio);
    }

    @Override
    public Cliente salvar(Cliente cliente) {

        ClienteJpaEntity clienteJpaEntity = clienteMapper.paraEntidade(cliente);

        return clienteMapper.paraDominio(clienteRepository.save(clienteJpaEntity));
    }
}

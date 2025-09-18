package br.com.tabuloja.adapters.persistence;

import br.com.tabuloja.adapters.persistence.mapper.PedidoMapper;
import br.com.tabuloja.adapters.repository.PedidoAluguelRepository;
import br.com.tabuloja.application.port.PedidoAluguelRepositoryPort;
import br.com.tabuloja.domain.PedidoAluguel;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PedidoAluguelPersistenceAdapter implements PedidoAluguelRepositoryPort {

    private final PedidoAluguelRepository  pedidoAluguelRepository;
    private final PedidoMapper mapper;

    public PedidoAluguelPersistenceAdapter(PedidoAluguelRepository pedidoAluguelRepository, PedidoMapper mapper) {
        this.pedidoAluguelRepository = pedidoAluguelRepository;
        this.mapper = mapper;
    }

    public PedidoAluguel salvar(PedidoAluguel pedidoAluguel) {

        PedidoAluguelJpaEntity pedidoAluguelJpaEntity = mapper.paraEntidade(pedidoAluguel);

        return mapper.paraDominio(pedidoAluguelRepository.save(pedidoAluguelJpaEntity));
    }

    public Optional<PedidoAluguel> buscarPorId(UUID id) {
        Optional<PedidoAluguelJpaEntity> entidadeOptional = pedidoAluguelRepository.findById(id);
        return entidadeOptional.map(mapper::paraDominio);
    }
}

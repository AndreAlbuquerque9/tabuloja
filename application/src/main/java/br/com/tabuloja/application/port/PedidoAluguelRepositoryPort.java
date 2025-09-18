package br.com.tabuloja.application.port;

import br.com.tabuloja.domain.PedidoAluguel;

import java.util.Optional;
import java.util.UUID;

public interface PedidoAluguelRepositoryPort {
    PedidoAluguel salvar(PedidoAluguel pedidoAluguel);
    Optional<PedidoAluguel> buscarPorId(UUID id);
}

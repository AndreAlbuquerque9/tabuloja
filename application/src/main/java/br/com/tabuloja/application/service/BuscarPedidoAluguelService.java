package br.com.tabuloja.application.service;

import br.com.tabuloja.application.port.PedidoAluguelRepositoryPort;
import br.com.tabuloja.domain.PedidoAluguel;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuscarPedidoAluguelService {

    private final PedidoAluguelRepositoryPort pedidoAluguelRepositoryPort;

    public BuscarPedidoAluguelService(PedidoAluguelRepositoryPort pedidoAluguelRepositoryPort) {
        this.pedidoAluguelRepositoryPort = pedidoAluguelRepositoryPort;
    }

    public PedidoAluguel buscarPedidoAluguelPorId(UUID id) {
        return pedidoAluguelRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pedido de aluguel não encontrado"));
    }
}

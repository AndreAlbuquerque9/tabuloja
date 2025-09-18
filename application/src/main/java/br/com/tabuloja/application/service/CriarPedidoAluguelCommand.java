package br.com.tabuloja.application.service;

import java.util.List;
import java.util.UUID;

public record CriarPedidoAluguelCommand(
        String clienteCpf,
        List<UUID> jogosIds,
        int diasAluguel
) {
}

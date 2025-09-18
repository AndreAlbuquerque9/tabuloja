package br.com.tabuloja.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record PedidoAluguel(
        UUID id,
        String clienteCpf,
        List<UUID> jogosIds,
        LocalDate dataPedido,
        int diasAluguel,
        BigDecimal valorTotal,
        StatusPedido status
) {}

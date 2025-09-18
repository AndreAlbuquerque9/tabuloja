package br.com.tabuloja.adapters.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record CriarPedidoAluguelRequest(

        @NotNull(message = "O CPF do cliente não pode ser nulo")
        String clienteCpf,

        @NotEmpty(message = "A lista de jogos não pode ser vazia")
        List<UUID> jogosIds,

        @Min(value = 1, message = "O aluguel deve ser de no minimo 1 dia")
        int diasAluguel
) {
}

package br.com.tabuloja.adapters.web.dto;

import jakarta.validation.constraints.NotNull;

public record CadastrarClienteRequest(

        @NotNull(message = "O CPF do cliente não pode ser nulo")
        String clienteCpf,

        @NotNull(message = "O nome não pode ser nulo")
        String nome,

        @NotNull(message = "O email não pode ser nulo")
        String email
) {}

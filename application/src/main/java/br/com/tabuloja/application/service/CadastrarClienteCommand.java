package br.com.tabuloja.application.service;

public record CadastrarClienteCommand(
   String nome,
   String email,
   String clienteCpf
) {}

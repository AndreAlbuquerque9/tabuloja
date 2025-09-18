package br.com.tabuloja.application.service;

import br.com.tabuloja.domain.CategoriaPreco;

import java.util.List;

public record CadastrarJogoDeTabuleiroCommand(
        String titulo,
        int anoLancamento,
        String descricao,
        int minJogadores,
        int maxJogadores,
        int tempoMedioMinutos,
        int idadeMinima,
        List<String> autores,
        String publisher,
        CategoriaPreco categoria
) {
}

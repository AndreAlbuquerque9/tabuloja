package br.com.tabuloja.adapters.web.dto;

import br.com.tabuloja.domain.CategoriaPreco;

import java.util.List;

public record CadastrarJogoDeTabuleiroRequest(
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

package br.com.tabuloja.domain;

import java.util.List;
import java.util.UUID;

public record JogoDeTabuleiro(
        UUID id,
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
    public JogoDeTabuleiro(String titulo, int anoLancamento, String descricao, int minJogadores, int maxJogadores, int tempoMedioMinutos, int idadeMinima, List<String> autores, String publisher, CategoriaPreco categoria) {
        this(null, titulo, anoLancamento, descricao, minJogadores, maxJogadores, tempoMedioMinutos, idadeMinima, autores, publisher, categoria);
    }
}

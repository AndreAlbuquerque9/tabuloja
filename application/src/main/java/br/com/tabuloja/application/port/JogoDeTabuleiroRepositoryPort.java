package br.com.tabuloja.application.port;

import br.com.tabuloja.domain.JogoDeTabuleiro;

import java.util.List;
import java.util.UUID;

public interface JogoDeTabuleiroRepositoryPort {

    List<JogoDeTabuleiro> findAllById(List<UUID> jogosIds);

    JogoDeTabuleiro salvar(JogoDeTabuleiro jogoDeTabuleiro);

    List<JogoDeTabuleiro> findByTituloContainingIgnoreCase(String titulo);
}

package br.com.tabuloja.adapters.persistence.mapper;

import br.com.tabuloja.adapters.persistence.JogoDeTabuleiroJpaEntity;
import br.com.tabuloja.domain.JogoDeTabuleiro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JogoDeTabuleiroMapper {

    JogoDeTabuleiroJpaEntity paraEntidade(JogoDeTabuleiro jogoDeTabuleiro);

    JogoDeTabuleiro paraDominio(JogoDeTabuleiroJpaEntity jogoDeTabuleiro);
}

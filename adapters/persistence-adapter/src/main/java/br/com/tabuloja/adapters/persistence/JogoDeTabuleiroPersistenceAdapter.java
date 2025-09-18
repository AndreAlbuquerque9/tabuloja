package br.com.tabuloja.adapters.persistence;

import br.com.tabuloja.adapters.persistence.mapper.JogoDeTabuleiroMapper;
import br.com.tabuloja.adapters.repository.JogoDeTabuleiroRepository;
import br.com.tabuloja.application.port.JogoDeTabuleiroRepositoryPort;
import br.com.tabuloja.domain.JogoDeTabuleiro;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class JogoDeTabuleiroPersistenceAdapter implements JogoDeTabuleiroRepositoryPort {

    private final JogoDeTabuleiroRepository jogoDeTabuleiroRepository;
    private final JogoDeTabuleiroMapper jogoDeTabuleiroMapper;

    public JogoDeTabuleiroPersistenceAdapter(JogoDeTabuleiroRepository jogoDeTabuleiroRepository, JogoDeTabuleiroMapper jogoDeTabuleiroMapper) {
        this.jogoDeTabuleiroRepository = jogoDeTabuleiroRepository;
        this.jogoDeTabuleiroMapper = jogoDeTabuleiroMapper;
    }

    @Override
    public List<JogoDeTabuleiro> findAllById(List<UUID> jogosIds) {

        List<JogoDeTabuleiroJpaEntity> jogosDoPedido = jogoDeTabuleiroRepository.findAllById(jogosIds);


        return jogosDoPedido.stream().map(jogoDeTabuleiroMapper::paraDominio).toList();
    }

    @Override
    public JogoDeTabuleiro salvar(JogoDeTabuleiro jogoDeTabuleiro) {
        JogoDeTabuleiroJpaEntity jogoDeTabuleiroJpaEntity = jogoDeTabuleiroMapper.paraEntidade(jogoDeTabuleiro);
        return jogoDeTabuleiroMapper.paraDominio(jogoDeTabuleiroRepository.save(jogoDeTabuleiroJpaEntity));
    }
}

package br.com.tabuloja.application.service;

import br.com.tabuloja.application.port.JogoDeTabuleiroRepositoryPort;
import br.com.tabuloja.domain.JogoDeTabuleiro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoDeTabuleiroService {

    private final JogoDeTabuleiroRepositoryPort jogoDeTabuleiroRepositoryPort;

    public JogoDeTabuleiroService(JogoDeTabuleiroRepositoryPort jogoDeTabuleiroRepositoryPort) {
        this.jogoDeTabuleiroRepositoryPort = jogoDeTabuleiroRepositoryPort;
    }

    public JogoDeTabuleiro cadastrar(CadastrarJogoDeTabuleiroCommand jogoDeTabuleiroCommand) {
        //TODO: Preciso voltar aqui pra criar algumas validações
        //Por exemplo checar se o jogo já existe

        JogoDeTabuleiro novoJogo = new JogoDeTabuleiro(
                null,
                jogoDeTabuleiroCommand.titulo(),
                jogoDeTabuleiroCommand.anoLancamento(),
                jogoDeTabuleiroCommand.descricao(),
                jogoDeTabuleiroCommand.minJogadores(),
                jogoDeTabuleiroCommand.maxJogadores(),
                jogoDeTabuleiroCommand.tempoMedioMinutos(),
                jogoDeTabuleiroCommand.idadeMinima(),
                jogoDeTabuleiroCommand.autores(),
                jogoDeTabuleiroCommand.publisher(),
                jogoDeTabuleiroCommand.categoria()
        );
        return jogoDeTabuleiroRepositoryPort.salvar(novoJogo);
    }

    public List<JogoDeTabuleiro> buscarPorTitulo(String titulo) {
        //TODO: Também criar algumas validações
        return jogoDeTabuleiroRepositoryPort.findByTituloContainingIgnoreCase(titulo);

    }
}

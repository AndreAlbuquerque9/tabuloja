package br.com.tabuloja;

import br.com.tabuloja.application.port.ClienteRepositoryPort;
import br.com.tabuloja.application.port.JogoDeTabuleiroRepositoryPort;
import br.com.tabuloja.domain.CategoriaPreco;
import br.com.tabuloja.domain.Cliente;
import br.com.tabuloja.domain.JogoDeTabuleiro;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClienteRepositoryPort clienteRepositoryPort;
    private final JogoDeTabuleiroRepositoryPort jogoDeTabuleiroRepositoryPort;

    public DataInitializer(ClienteRepositoryPort clienteRepositoryPort, JogoDeTabuleiroRepositoryPort jogoDeTabuleiroRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
        this.jogoDeTabuleiroRepositoryPort = jogoDeTabuleiroRepositoryPort;
    }

    @Override
    public void run(String... args) {
        System.out.println("Iniciando a popularização do banco de dados...");

        // Criando e salvando um cliente
        var cliente = new Cliente(
                "Andre Monteiro",
                "andre@tabuloja.com.br",
                "11122233344"
        );
        clienteRepositoryPort.salvar(cliente);

        // Criando e salvando um jogo
        var jogo = new JogoDeTabuleiro(
                "Catan",
                1995,
                "Um jogo de estratégia sobre colonizar uma ilha.",
                3, 4, 90, 10,
                List.of("Klaus Teuber"), // Adicionando o autor
                "Devir",
                CategoriaPreco.OURO // Usando o Enum
        );
        jogoDeTabuleiroRepositoryPort.salvar(jogo);


        System.out.println("Banco de dados populado com sucesso!");
    }
}

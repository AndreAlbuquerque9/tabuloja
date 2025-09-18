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

        var cliente = new Cliente(
                "Andre Monteiro",
                "andre@tabuloja.com.br",
                "11122233344"
        );
        clienteRepositoryPort.salvar(cliente);

        var jogo = new JogoDeTabuleiro(
                "Catan",
                1995,
                "Um jogo de estratégia sobre colonizar uma ilha.",
                3, 4, 90, 10,
                List.of("Klaus Teuber"),
                "Devir",
                CategoriaPreco.BRONZE
        );
        jogoDeTabuleiroRepositoryPort.salvar(jogo);

        var jogo1 = new JogoDeTabuleiro(
                "BackStabbers",
                2025,
                "Backstabbers é um Battle Royale de cartas, onde seu objetivo é utilizar as habilidades dos habitantes de Solara para eliminar seus oponentes, acumular moedas de ouro e se tornar o grande soberano.",
                3, 8, 45, 16,
                List.of("Pedro Cavalcanti", "Charles de Oliveira", "Lehi Henri"),
                "Solara Studios",
                CategoriaPreco.PRATA
        );
        jogoDeTabuleiroRepositoryPort.salvar(jogo1);

        var jogo2 = new JogoDeTabuleiro(
                "Terrafoming Mars",
                2016,
                "Um jogo sobre terraformar marte",
                3, 8, 45, 16,
                List.of("Jacob Fryxelius", "Isaac Fryxelius"),
                "Solara Studios",
                CategoriaPreco.OURO
        );
        jogoDeTabuleiroRepositoryPort.salvar(jogo2);


        System.out.println("Banco de dados populado com sucesso!");
    }
}

package br.com.tabuloja.application.service;

import br.com.tabuloja.application.exception.ClienteNaoEcontradoException;
import br.com.tabuloja.application.exception.JogoNaoDisponivelException;
import br.com.tabuloja.application.exception.JogoNaoEncontradoException;
import br.com.tabuloja.application.port.*;
import br.com.tabuloja.domain.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CriarPedidoAluguelService {

    private final InventarioRepositoryPort inventarioRepositoryPort;
    private final PedidoAluguelRepositoryPort pedidoAluguelRepositoryPort;
    private final GatewayPagamentoPort gatewayPagamentoPort;
    private final NotificacaoPort notificacaoPort;
    private final ClienteRepositoryPort clienteRepositoryPort;
    private final JogoDeTabuleiroRepositoryPort jogoDeTabuleiroRepositoryPort;

    public CriarPedidoAluguelService(InventarioRepositoryPort inventarioRepositoryPort,
                                     PedidoAluguelRepositoryPort pedidoAluguelRepositoryPort,
                                     GatewayPagamentoPort gatewayPagamentoPort,
                                     NotificacaoPort notificacaoPort,
                                     ClienteRepositoryPort clienteRepositoryPort,
                                     JogoDeTabuleiroRepositoryPort jogoDeTabuleiroRepositoryPort) {
        this.inventarioRepositoryPort = inventarioRepositoryPort;
        this.pedidoAluguelRepositoryPort = pedidoAluguelRepositoryPort;
        this.gatewayPagamentoPort = gatewayPagamentoPort;
        this.notificacaoPort = notificacaoPort;
        this.clienteRepositoryPort = clienteRepositoryPort;
        this.jogoDeTabuleiroRepositoryPort = jogoDeTabuleiroRepositoryPort;
    }

    public PedidoAluguel executar(CriarPedidoAluguelCommand command) {

        Cliente cliente = clienteRepositoryPort.buscarPorCpf(command.clienteCpf())
                .orElseThrow(() -> new ClienteNaoEcontradoException("Cliente com CPF " + command.clienteCpf() + " não econtrado"));

        List<JogoDeTabuleiro> jogosParaAlugar = jogoDeTabuleiroRepositoryPort.findAllById(command.jogosIds());
        if (jogosParaAlugar.size() != command.jogosIds().size()) {
            throw new JogoNaoEncontradoException("Um ou mais jogos solicitados não foram encontrados");
        }

        if (!inventarioRepositoryPort.verficarDisponibilidade(command.jogosIds())) {
            throw new JogoNaoDisponivelException("Jogo indisponivel");
        }

        BigDecimal valorTotal = calcularValor(jogosParaAlugar, command.diasAluguel());

//        if(!gatewayPagamentoPort.autorizarPagamento(valorTotal, /*dados do cliente*/)) {
//            throw new RuntimeException("Pagamento Recusado")
//        }
        PedidoAluguel novoPedido = new PedidoAluguel(
                null,
                cliente.cpf(),
                command.jogosIds(),
                LocalDate.now(),
                command.diasAluguel(),
                valorTotal,
                StatusPedido.APROVADO
        );
        PedidoAluguel pedidoSalvo = pedidoAluguelRepositoryPort.salvar(novoPedido);

        // Atualizar inventário e notificar
        inventarioRepositoryPort.atualizarStatus(command.jogosIds(), StatusInventario.INDISPONIVEL);
        //notificacaoPort.notificarNovoPedido(pedidoSalvo);

        return pedidoSalvo;
    }

    private BigDecimal calcularValor(List<JogoDeTabuleiro> jogos, int diasAluguel) {
        BigDecimal subTotalDiarias = jogos.stream()
                .map(jogo -> jogo.categoria().getPrecoDiaria())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return subTotalDiarias.multiply(BigDecimal.valueOf(diasAluguel));
    }
}

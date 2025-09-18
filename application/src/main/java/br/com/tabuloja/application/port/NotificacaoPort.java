package br.com.tabuloja.application.port;

import br.com.tabuloja.domain.PedidoAluguel;

public interface NotificacaoPort {
    void notificarNovoPedido(PedidoAluguel pedidoAluguel);
}

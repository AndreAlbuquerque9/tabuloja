package br.com.tabuloja.adapters.persistence;

import br.com.tabuloja.application.port.NotificacaoPort;
import br.com.tabuloja.domain.PedidoAluguel;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoPersistenceAdapter implements NotificacaoPort {
    @Override
    public void notificarNovoPedido(PedidoAluguel pedidoAluguel) {

    }
}

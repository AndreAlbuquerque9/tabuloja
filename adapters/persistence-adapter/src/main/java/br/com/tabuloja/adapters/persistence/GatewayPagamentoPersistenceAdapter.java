package br.com.tabuloja.adapters.persistence;

import br.com.tabuloja.application.port.GatewayPagamentoPort;
import br.com.tabuloja.domain.Cliente;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GatewayPagamentoPersistenceAdapter implements GatewayPagamentoPort {
    @Override
    public boolean autorizarPagamento(BigDecimal valor, Cliente cliente) {
        return true;
    }
}

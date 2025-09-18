package br.com.tabuloja.application.port;

import br.com.tabuloja.domain.Cliente;

import java.math.BigDecimal;

public interface GatewayPagamentoPort {
    boolean autorizarPagamento(BigDecimal valor, Cliente cliente);
}

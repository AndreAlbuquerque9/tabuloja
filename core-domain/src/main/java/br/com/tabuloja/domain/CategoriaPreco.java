package br.com.tabuloja.domain;

import java.math.BigDecimal;

public enum CategoriaPreco {
    BRONZE(new BigDecimal("20.00")),
    PRATA(new BigDecimal("30.00")),
    OURO(new BigDecimal("40.00"));

    private final BigDecimal precoDiaria;

    CategoriaPreco(BigDecimal precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public BigDecimal getPrecoDiaria() {
        return precoDiaria;
    }
}

package br.com.tabuloja.adapters.persistence.mapper;

import br.com.tabuloja.adapters.persistence.PedidoAluguelJpaEntity;
import br.com.tabuloja.domain.PedidoAluguel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoAluguelJpaEntity paraEntidade(PedidoAluguel pedidoAluguel);

    PedidoAluguel paraDominio(PedidoAluguelJpaEntity pedidoAluguel);
}

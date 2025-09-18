package br.com.tabuloja.adapters.web.mapper;

import br.com.tabuloja.adapters.web.dto.CriarPedidoAluguelRequest;
import br.com.tabuloja.application.service.CriarPedidoAluguelCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoWebRequestMapper {

    CriarPedidoAluguelCommand paraCommand(CriarPedidoAluguelRequest request);
}

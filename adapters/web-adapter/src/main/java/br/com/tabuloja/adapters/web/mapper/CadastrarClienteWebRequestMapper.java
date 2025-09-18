package br.com.tabuloja.adapters.web.mapper;

import br.com.tabuloja.adapters.web.dto.CadastrarClienteRequest;
import br.com.tabuloja.application.service.CadastrarClienteCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CadastrarClienteWebRequestMapper {

    CadastrarClienteCommand paraCommand(CadastrarClienteRequest cadastrarClienteRequest);
}

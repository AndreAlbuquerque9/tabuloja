package br.com.tabuloja.adapters.web.mapper;

import br.com.tabuloja.adapters.web.dto.CadastrarJogoDeTabuleiroRequest;
import br.com.tabuloja.application.service.CadastrarJogoDeTabuleiroCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CadastrarJogoDeTabuleiroMapper {

    CadastrarJogoDeTabuleiroCommand paraCommand(CadastrarJogoDeTabuleiroRequest cadastrarJogoDeTabuleiroRequest);
}

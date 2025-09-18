package br.com.tabuloja.adapters.persistence.mapper;

import br.com.tabuloja.adapters.persistence.ClienteJpaEntity;
import br.com.tabuloja.domain.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteJpaEntity paraEntidade(Cliente cliente);

    Cliente paraDominio(ClienteJpaEntity cliente);
}

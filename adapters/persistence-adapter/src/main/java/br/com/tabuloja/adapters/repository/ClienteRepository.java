package br.com.tabuloja.adapters.repository;

import br.com.tabuloja.adapters.persistence.ClienteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteJpaEntity, String> {

    Optional<ClienteJpaEntity> findByCpf(String cpf);
}

package br.com.tabuloja.adapters.repository;

import br.com.tabuloja.adapters.persistence.PedidoAluguelJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedidoAluguelRepository extends JpaRepository<PedidoAluguelJpaEntity, UUID> {
}

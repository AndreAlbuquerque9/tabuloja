package br.com.tabuloja.adapters.repository;

import br.com.tabuloja.adapters.persistence.JogoDeTabuleiroJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JogoDeTabuleiroRepository extends JpaRepository<JogoDeTabuleiroJpaEntity, UUID> {
}

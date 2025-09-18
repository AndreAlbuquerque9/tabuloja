package br.com.tabuloja.adapters.persistence;

import br.com.tabuloja.application.port.InventarioRepositoryPort;
import br.com.tabuloja.domain.StatusInventario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class InventarioPersistenceAdapter implements InventarioRepositoryPort {
    @Override
    public boolean verficarDisponibilidade(List<UUID> jogosIds) {
        return true;
    }

    @Override
    public void atualizarStatus(List<UUID> jogosIds, StatusInventario statusInventario) {

    }
}

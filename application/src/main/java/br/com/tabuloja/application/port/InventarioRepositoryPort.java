package br.com.tabuloja.application.port;

import br.com.tabuloja.domain.StatusInventario;

import java.util.List;
import java.util.UUID;

public interface InventarioRepositoryPort {
    boolean verficarDisponibilidade(List<UUID> jogosIds);
    void atualizarStatus(List<UUID> jogosIds, StatusInventario statusInventario);
}

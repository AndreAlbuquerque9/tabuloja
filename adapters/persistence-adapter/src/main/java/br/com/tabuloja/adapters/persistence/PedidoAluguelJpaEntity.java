package br.com.tabuloja.adapters.persistence;

import br.com.tabuloja.domain.StatusPedido;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedidos_aluguel")
public class PedidoAluguelJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String clienteCpf;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "pedidos_jogos", joinColumns = @JoinColumn(name = "pedido_id"))
    @Column(name = "jogo_id", nullable = false)
    private List<UUID> jogosIds;

    @Column(nullable = false)
    private LocalDate dataPedido;

    private int diasAluguel;
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public PedidoAluguelJpaEntity() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteId) {
        this.clienteCpf = clienteId;
    }

    public List<UUID> getJogosIds() {
        return jogosIds;
    }

    public void setJogosIds(List<UUID> jogosIds) {
        this.jogosIds = jogosIds;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getDiasAluguel() {
        return diasAluguel;
    }

    public void setDiasAluguel(int diasAluguel) {
        this.diasAluguel = diasAluguel;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}

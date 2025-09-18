package br.com.tabuloja.adapters.persistence;

import br.com.tabuloja.domain.CategoriaPreco;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "jogo_de_tabuleiro")
public class JogoDeTabuleiroJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private int anoLancamento;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int minJogadores;

    @Column(nullable = false)
    private int maxJogadores;

    @Column(nullable = false)
    private int tempoMedioMinutos;

    @Column(nullable = false)
    private int idadeMinima;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "jogo_autores", joinColumns = @JoinColumn(name = "jogo_id"))
    @Column(nullable = false)
    private List<String> autores;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaPreco categoria;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getMinJogadores() {
        return minJogadores;
    }

    public void setMinJogadores(int minJogadores) {
        this.minJogadores = minJogadores;
    }

    public int getMaxJogadores() {
        return maxJogadores;
    }

    public void setMaxJogadores(int maxJogadores) {
        this.maxJogadores = maxJogadores;
    }

    public int getTempoMedioMinutos() {
        return tempoMedioMinutos;
    }

    public void setTempoMedioMinutos(int tempoMedioMinutos) {
        this.tempoMedioMinutos = tempoMedioMinutos;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public CategoriaPreco getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPreco categoria) {
        this.categoria = categoria;
    }
}

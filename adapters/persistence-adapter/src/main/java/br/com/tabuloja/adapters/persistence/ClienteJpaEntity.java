package br.com.tabuloja.adapters.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class ClienteJpaEntity {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Id
    @Column(nullable = false)
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String documento) {
        this.cpf = documento;
    }
}

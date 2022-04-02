package br.edu.unoesc.desafiofullstackunoesc.entities;

import javax.persistence.*;

@Entity
@Table(name = "unidadefederativa")
public class UnidadeFederativaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long codigo;

    @Column(nullable = false, unique = true)
    private String sigla;
    @Column(nullable = false, unique = true)
    private String nome;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}

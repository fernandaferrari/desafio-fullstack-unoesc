package br.edu.unoesc.desafiofullstackunoesc.models;

import javax.persistence.*;

@Entity
@Table(name = "unidadefederativa")
public class UnidadeFederativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(nullable = false)
    private String sigla;
    @Column(nullable = false)
    private String nome;
    
    public UnidadeFederativa(int codigo, String sigla, String nome) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.nome = nome;
    }

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

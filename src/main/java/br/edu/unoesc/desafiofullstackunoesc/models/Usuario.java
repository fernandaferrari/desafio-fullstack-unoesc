package br.edu.unoesc.desafiofullstackunoesc.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long codigo;
    
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false)
    private String password;
    
    public Usuario(long codigo, String nome, String password) {
        this.codigo = codigo;
        this.nome = nome;
        this.password = password;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

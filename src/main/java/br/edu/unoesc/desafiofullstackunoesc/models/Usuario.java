package br.edu.unoesc.desafiofullstackunoesc.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    private String nome;
    private String password;
    private String confirmPassword;
    
    public Usuario(long codigo, String nome, String password, String confirmPassword) {
        this.codigo = codigo;
        this.nome = nome;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

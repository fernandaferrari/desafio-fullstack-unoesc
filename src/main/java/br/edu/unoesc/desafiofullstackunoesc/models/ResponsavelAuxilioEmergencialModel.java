package br.edu.unoesc.desafiofullstackunoesc.models;

public class ResponsavelAuxilioEmergencialModel {
    private String cpfFormatado;
    private String nis;
    private String nome;

    // Getter Methods

    public String getCpfFormatado() {
        return cpfFormatado;
    }

    public String getNis() {
        return nis;
    }

    public String getNome() {
        return nome;
    }

    // Setter Methods

    public void setCpfFormatado(String cpfFormatado) {
        this.cpfFormatado = cpfFormatado;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

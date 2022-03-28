package br.edu.unoesc.desafiofullstackunoesc.models;

import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "auxilioemergencial")
public class AuxilioEmergencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(nullable = false)
    private Date dataConsulta;
    @Column(nullable = false)
    private String numeroParcela;
    @Column(nullable = false)
    private DecimalFormat valorTotal;
    
    @ManyToOne
    @JoinColumn(name = "municipio_codigo", referencedColumnName = "codigo", nullable = false)
    private Municipio municipio;

    public AuxilioEmergencial(
            int codigo, Date dataConsulta, Municipio municipio, String numeroParcela,
            DecimalFormat valorTotal) {
        this.codigo = codigo;
        this.dataConsulta = dataConsulta;
        this.municipio = municipio;
        this.numeroParcela = numeroParcela;
        this.valorTotal = valorTotal;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(String numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public DecimalFormat getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(DecimalFormat valorTotal) {
        this.valorTotal = valorTotal;
    }

    
}

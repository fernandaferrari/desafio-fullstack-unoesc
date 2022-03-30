package br.edu.unoesc.desafiofullstackunoesc.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "auxilioemergencial")
public class AuxilioEmergencialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long codigo;

    @Column(nullable = false)
    private Date dataConsulta;
    @Column(nullable = false)
    private String numeroParcela;
    @Column(nullable = false)
    private BigDecimal valorTotal;
    
    @ManyToOne
    @JoinColumn(name = "municipio_id", referencedColumnName = "id", nullable = false)
    private MunicipioEntity municipio;


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

    public MunicipioEntity getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioEntity municipio) {
        this.municipio = municipio;
    }

    public String getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(String numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    
}

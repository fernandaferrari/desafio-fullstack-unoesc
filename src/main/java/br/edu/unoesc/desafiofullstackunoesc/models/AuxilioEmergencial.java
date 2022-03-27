package br.edu.unoesc.desafiofullstackunoesc.models;

import java.math.BigDecimal;
import java.util.Date;

public class AuxilioEmergencial {
    protected long codigo;
    protected Date dataConsulta;
    protected Municipio municipio;
    protected String numeroParcela;
    protected BigDecimal valorTotal;

    public AuxilioEmergencial(long codigo, Date dataConsulta, Municipio municipio, String numeroParcela,
            BigDecimal valorTotal) {
        this.codigo = codigo;
        this.dataConsulta = dataConsulta;
        this.municipio = municipio;
        this.numeroParcela = numeroParcela;
        this.valorTotal = valorTotal;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    
}

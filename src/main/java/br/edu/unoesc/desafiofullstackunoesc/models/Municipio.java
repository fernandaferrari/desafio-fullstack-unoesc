package br.edu.unoesc.desafiofullstackunoesc.models;

import javax.persistence.*;

@Entity
@Table(name = "municipio")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long codigo;

    @Column(nullable = false)
    private long codigoIBGE;
    @Column(length = 100, nullable = false)
    private String nomeIBGE;
    @Column(length = 50, nullable = false)
    private String codigoRegiao;
    @Column(nullable = false)
    private String pais;

    @ManyToOne
    @JoinColumn(name = "unidadefederativa_id", referencedColumnName = "id")
    private UnidadeFederativa unidadeFederativa;
    
    public Municipio(
            long codigo, 
            long codigoIBGE, String nomeIBGE, String codigoRegiao, String pais,
            UnidadeFederativa unidadeFederativa) {
        this.codigo = codigo;
        this.codigoIBGE = codigoIBGE;
        this.nomeIBGE = nomeIBGE;
        this.codigoRegiao = codigoRegiao;
        this.pais = pais;
        this.unidadeFederativa = unidadeFederativa;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(long codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public String getNomeIBGE() {
        return nomeIBGE;
    }

    public void setNomeIBGE(String nomeIBGE) {
        this.nomeIBGE = nomeIBGE;
    }

    public String getCodigoRegiao() {
        return codigoRegiao;
    }

    public void setCodigoRegiao(String codigoRegiao) {
        this.codigoRegiao = codigoRegiao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public UnidadeFederativa getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    
}

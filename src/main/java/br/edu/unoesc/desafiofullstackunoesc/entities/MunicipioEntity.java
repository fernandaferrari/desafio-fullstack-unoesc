package br.edu.unoesc.desafiofullstackunoesc.entities;

import javax.persistence.*;

@Entity
@Table(name = "municipio")
public class MunicipioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long codigo;

    @Column(nullable = false, unique = true)
    private long codigoIBGE;
    @Column(length = 100, nullable = false)
    private String nomeIBGE;
    @Column(length = 50, nullable = false)
    private String codigoRegiao;
    @Column(nullable = false)
    private String pais;

    @ManyToOne
    @JoinColumn(name = "unidadefederativa_id", referencedColumnName = "id")
    private UnidadeFederativaEntity unidadeFederativa;

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

    public UnidadeFederativaEntity getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(UnidadeFederativaEntity unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    @Override
    public String toString() {
        return "MunicipioEntity [nomeIBGE=" + nomeIBGE + "]";
    }

    
}

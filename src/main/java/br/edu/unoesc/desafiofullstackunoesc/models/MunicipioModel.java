package br.edu.unoesc.desafiofullstackunoesc.models;

public class MunicipioModel {
    private String codigoIBGE;
    private String nomeIBGE;
    private String codigoRegiao;
    private String nomeRegiao;
    private String pais;
    UfModel UfObject;

    // Getter Methods

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public String getNomeIBGE() {
        return nomeIBGE;
    }

    public String getCodigoRegiao() {
        return codigoRegiao;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public String getPais() {
        return pais;
    }

    public UfModel getUf() {
        return UfObject;
    }

    // Setter Methods

    public void setCodigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public void setNomeIBGE(String nomeIBGE) {
        this.nomeIBGE = nomeIBGE;
    }

    public void setCodigoRegiao(String codigoRegiao) {
        this.codigoRegiao = codigoRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setUf(UfModel ufObject) {
        this.UfObject = ufObject;
    }
}

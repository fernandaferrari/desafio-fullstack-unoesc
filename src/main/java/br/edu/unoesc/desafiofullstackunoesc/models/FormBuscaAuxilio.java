package br.edu.unoesc.desafiofullstackunoesc.models;

public class FormBuscaAuxilio {
    private String codigoIbge;
    private int anoMes;
    
    public int getAnoMes() {
        return anoMes;
    }
    public String getCodigoIbge() {
        return codigoIbge;
    }
    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }
    public void setAnoMes(int anoMes) {
        this.anoMes = anoMes;
    }
}

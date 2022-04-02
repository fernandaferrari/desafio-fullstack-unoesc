package br.edu.unoesc.desafiofullstackunoesc.models;

public class AuxilioEmergencialModel {
 private float id;
 private String mesDisponibilizacao;
 BeneficiarioModel beneficiario;
 ResponsavelAuxilioEmergencialModel ResponsavelAuxilioEmergencialObject;
 MunicipioModel municipio;
 private String situacaoAuxilioEmergencial;
 private String enquadramentoAuxilioEmergencial;
 private float valor;
 private String numeroParcela;


 // Getter Methods 

 public float getId() {
  return id;
 }

 public String getMesDisponibilizacao() {
  return mesDisponibilizacao;
 }

 public BeneficiarioModel getBeneficiario() {
  return beneficiario;
 }

 public ResponsavelAuxilioEmergencialModel getResponsavelAuxilioEmergencial() {
  return ResponsavelAuxilioEmergencialObject;
 }

 public MunicipioModel getMunicipio() {
  return municipio;
 }

 public String getSituacaoAuxilioEmergencial() {
  return situacaoAuxilioEmergencial;
 }

 public String getEnquadramentoAuxilioEmergencial() {
  return enquadramentoAuxilioEmergencial;
 }

 public float getValor() {
  return valor;
 }

 public String getNumeroParcela() {
  return numeroParcela;
 }

 // Setter Methods 

 public void setId(float id) {
  this.id = id;
 }

 public void setMesDisponibilizacao(String mesDisponibilizacao) {
  this.mesDisponibilizacao = mesDisponibilizacao;
 }

 public void setBeneficiario(BeneficiarioModel beneficiario) {
  this.beneficiario = beneficiario;
 }

 public void setResponsavelAuxilioEmergencial(ResponsavelAuxilioEmergencialModel responsavelAuxilioEmergencialObject) {
  this.ResponsavelAuxilioEmergencialObject = responsavelAuxilioEmergencialObject;
 }

 public void setMunicipio(MunicipioModel municipio) {
  this.municipio = municipio;
 }

 public void setSituacaoAuxilioEmergencial(String situacaoAuxilioEmergencial) {
  this.situacaoAuxilioEmergencial = situacaoAuxilioEmergencial;
 }

 public void setEnquadramentoAuxilioEmergencial(String enquadramentoAuxilioEmergencial) {
  this.enquadramentoAuxilioEmergencial = enquadramentoAuxilioEmergencial;
 }

 public void setValor(float valor) {
  this.valor = valor;
 }

 public void setNumeroParcela(String numeroParcela) {
  this.numeroParcela = numeroParcela;
 }
}





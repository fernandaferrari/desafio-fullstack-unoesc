package br.edu.unoesc.desafiofullstackunoesc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.desafiofullstackunoesc.models.AuxilioEmergencial;
import br.edu.unoesc.desafiofullstackunoesc.service.AuxilioEmergencialBeneficiarioMunicipioService;



@Controller
@RequestMapping("/buscarAuxilio")
public class AuxilioEmergencialBeneficiarioMunicipioController {

    @Autowired
    private AuxilioEmergencialBeneficiarioMunicipioService service;

    @GetMapping("auxilio")
    public ResponseEntity<AuxilioEmergencial> obterAuxilio(String codigoIbge, int mesAno, int pagina){

        AuxilioEmergencial auxilio = this.service.obterAuxilioPorMunicipio(codigoIbge, mesAno, pagina);

        return ResponseEntity.ok(auxilio);
    }
}

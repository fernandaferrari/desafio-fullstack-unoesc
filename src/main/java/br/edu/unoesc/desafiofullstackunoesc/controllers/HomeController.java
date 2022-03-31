package br.edu.unoesc.desafiofullstackunoesc.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.desafiofullstackunoesc.entities.AuxilioEmergencialEntity;
import br.edu.unoesc.desafiofullstackunoesc.service.AuxilioEmergencialBeneficiarioMunicipioService;

@Controller
public class HomeController {

    @Autowired
    private AuxilioEmergencialBeneficiarioMunicipioService service;

    @GetMapping("/home")
    public String index() {
        return "home/buscar-auxilio";
    }

    @PostMapping("/buscar")
    public ResponseEntity<AuxilioEmergencialEntity> obterAuxilio(String codigoIbge, int mesAno) throws IOException {
        AuxilioEmergencialEntity auxilio = new AuxilioEmergencialEntity();
        this.service.obterAuxilioPorMunicipio(codigoIbge, mesAno);

        return ResponseEntity.ok(auxilio);
    }

    

}
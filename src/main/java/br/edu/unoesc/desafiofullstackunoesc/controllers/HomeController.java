package br.edu.unoesc.desafiofullstackunoesc.controllers;

import java.io.IOException;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String obterAuxilio(Model model, String codigoIbge, int mesAno) throws IOException, JSONException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try {
            AuxilioEmergencialEntity auxilio = new AuxilioEmergencialEntity();
            this.service.obterAuxilioPorMunicipio(codigoIbge, mesAno);

            ResponseEntity.ok(auxilio);

            model.addAttribute("success", "Arquivo salvo em Downloads com sucesso");
        } catch (Exception e) {
            model.addAttribute("erro", "Erro ao gerar arquivo");
        }

        return "redirect:/home";
    }

    

}
package br.edu.unoesc.desafiofullstackunoesc.controllers;

import java.io.IOException;
import java.text.ParseException;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String obterAuxilio(Model model, String codigoIbge, String mesAno) throws IOException, JSONException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, ParseException {

            boolean result = service.obterAuxilioPorMunicipio(codigoIbge, mesAno);

            if(result == true){
                model.addAttribute("success", "Arquivo salvo em Downloads com sucesso");
                return "home/buscar-auxilio";
            }          
        
        model.addAttribute("erro", "Lista vazia");
        return "home/buscar-auxilio";
    }

    

}
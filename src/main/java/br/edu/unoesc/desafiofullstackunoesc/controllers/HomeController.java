package br.edu.unoesc.desafiofullstackunoesc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String index() {
        return "home/buscar-auxilio";
    }

    @PostMapping("/buscar-auxilio")
    public String salvarUser(Model model, String codigoIbge, int mesAno) {

        System.out.println(codigoIbge);
        System.out.println(mesAno);
        return "home/buscar-auxilio";
    }

}
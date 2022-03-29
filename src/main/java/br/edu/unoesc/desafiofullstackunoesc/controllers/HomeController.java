package br.edu.unoesc.desafiofullstackunoesc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.desafiofullstackunoesc.models.FormBuscaAuxilio;



@Controller
public class HomeController {

    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("home", new FormBuscaAuxilio());
        return "home/buscar-auxilio";
    }

    @PostMapping("/home")
    public String salvarUser(@ModelAttribute FormBuscaAuxilio buscar) {

        System.out.println(buscar);
        return "home/buscar-auxilio";
    }


    // @GetMapping("/home")
    // public String index(Model model) {
    //     model.addAttribute("buscar", new Object());

    //     return "home/home";
    // }

    // @PostMapping("/home")
    // public String salvarUser(@ModelAttribute Object buscar) {

    //     System.out.println(buscar);
    //     return "home/home";
    // }

}
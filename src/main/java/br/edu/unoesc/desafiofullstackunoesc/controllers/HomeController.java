package br.edu.unoesc.desafiofullstackunoesc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    
    @GetMapping("/")
    public String index() {

        return "home/home";
    }
}

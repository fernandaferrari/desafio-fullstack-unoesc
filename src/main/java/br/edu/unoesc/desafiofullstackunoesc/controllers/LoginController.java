package br.edu.unoesc.desafiofullstackunoesc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String index() {
		return "login/index";
	}

	@GetMapping("/cadastro")
	public String cadastro() {
		return "signup/cadastro";
	}
}

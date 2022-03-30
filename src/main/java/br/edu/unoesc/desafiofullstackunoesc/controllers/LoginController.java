package br.edu.unoesc.desafiofullstackunoesc.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.desafiofullstackunoesc.models.Usuario;
import br.edu.unoesc.desafiofullstackunoesc.service.CookieService;
import br.edu.unoesc.desafiofullstackunoesc.service.UsuarioService;


@Controller
public class LoginController {

	@Autowired
	UsuarioService userService;

	@GetMapping("/login")
	public String index() {
		
        return "login/index";
	}

	@PostMapping("/logar")
	public String logar(Model model, Usuario usuarioParam, HttpServletResponse response) {

		Usuario result = userService.checkAccount(usuarioParam);

		if (result != null) {
			CookieService.setCookie(response, "usuariosId", String.valueOf(result.getCodigo()), 5);
			return "redirect:/home";
		} 
			
		model.addAttribute("erro", "Usuário ou senha invalidos");
		return "login/index";
	}
}

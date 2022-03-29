package br.edu.unoesc.desafiofullstackunoesc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.desafiofullstackunoesc.models.Usuario;
import br.edu.unoesc.desafiofullstackunoesc.service.UsuarioService;


@Controller
public class CadastroController {

    @Autowired
    UsuarioService userService;
    
    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("cadastro", new Usuario());

        return "cadastro/cadastro-usuario";
    }

    @PostMapping("/cadastro")
    public String salvarUser(@ModelAttribute Usuario usuario) {

        userService.salvar(usuario);

        return "/home/home";
    }


}

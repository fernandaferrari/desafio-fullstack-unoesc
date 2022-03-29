package br.edu.unoesc.desafiofullstackunoesc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.desafiofullstackunoesc.models.Usuario;
import br.edu.unoesc.desafiofullstackunoesc.service.UsuarioService;


@Controller
public class CadastroController {

    @Autowired
    UsuarioService userService;
    
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro/cadastro-usuario";
    }

    @PostMapping(value = "/salvar-usuario")
    public String salvarUser(Usuario usuario) {
        userService.salvar(usuario);

        return "cadastro/cadastro-usuario";
    }


}

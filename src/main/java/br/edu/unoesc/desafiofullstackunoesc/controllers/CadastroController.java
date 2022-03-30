package br.edu.unoesc.desafiofullstackunoesc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.desafiofullstackunoesc.entities.UsuarioEntity;
import br.edu.unoesc.desafiofullstackunoesc.service.UsuarioService;


@Controller
public class CadastroController {

    @Autowired
    UsuarioService userService;
    
    @GetMapping("/cadastro")
    public String cadastro() {

        return "cadastro/cadastro-usuario";
    }

    @PostMapping("/cadastrar")
    public String salvarUser(Model model, String nome, String password) {

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome(nome);
        usuario.setPassword(password);

        Boolean result = userService.salvar(usuario);

        if(result == true){
            return "redirect:/home";
        }

        model.addAttribute("erro", "Usuário já cadastrado");
        return "cadastro/cadastro-usuario";
    }


}

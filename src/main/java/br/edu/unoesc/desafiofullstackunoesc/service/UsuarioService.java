package br.edu.unoesc.desafiofullstackunoesc.service;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.edu.unoesc.desafiofullstackunoesc.models.Usuario;
import br.edu.unoesc.desafiofullstackunoesc.repositories.UsuarioRepository;

@Component
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Usuario salvar(Usuario usuario){

        usuario.setPassword(criptografarSenha(usuario.getPassword()));

        return repository.save(usuario);
    }

    public static String criptografarSenha(String senha){
        String senhaCripto = "";

        MessageDigest md;

        try{
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            senhaCripto = hash.toString(16);

        }catch(Exception e){}

        return senhaCripto;
    }


    public Usuario checkAccount(Usuario usuario) {
        usuario.setPassword(criptografarSenha(usuario.getPassword()));

        Usuario user = this.repository.login(usuario.getNome(), usuario.getPassword());

        return user;

    }
}

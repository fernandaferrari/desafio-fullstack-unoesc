package br.edu.unoesc.desafiofullstackunoesc.service;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.edu.unoesc.desafiofullstackunoesc.entities.UsuarioEntity;
import br.edu.unoesc.desafiofullstackunoesc.repositories.UsuarioRepository;

@Component
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Boolean salvar(UsuarioEntity usuario){
        try{
            usuario.setPassword(criptografarSenha(usuario.getPassword()));

            repository.save(usuario);
        }catch (Exception e){
            return false;
        }
        
        return true;
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


    public UsuarioEntity checkAccount(UsuarioEntity usuario) {
        usuario.setPassword(criptografarSenha(usuario.getPassword()));

        UsuarioEntity user = this.repository.login(usuario.getNome(), usuario.getPassword());

        return user;

    }
}

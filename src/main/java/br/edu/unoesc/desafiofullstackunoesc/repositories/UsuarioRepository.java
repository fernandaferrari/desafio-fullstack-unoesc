package br.edu.unoesc.desafiofullstackunoesc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.desafiofullstackunoesc.models.Usuario;

@Repository
@Component
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select * from usuario where nome = :nome and password = :password", nativeQuery = true)
    public Usuario login(String nome, String password); 

}

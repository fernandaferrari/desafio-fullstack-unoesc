package br.edu.unoesc.desafiofullstackunoesc.repositories;

import org.springframework.data.repository.CrudRepository;

import br.edu.unoesc.desafiofullstackunoesc.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}

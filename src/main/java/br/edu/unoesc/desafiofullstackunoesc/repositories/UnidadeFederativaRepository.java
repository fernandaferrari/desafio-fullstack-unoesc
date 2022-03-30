package br.edu.unoesc.desafiofullstackunoesc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.desafiofullstackunoesc.entities.UnidadeFederativaEntity;

@Repository
public interface UnidadeFederativaRepository extends JpaRepository<UnidadeFederativaEntity, Long> {

}
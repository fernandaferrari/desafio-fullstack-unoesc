package br.edu.unoesc.desafiofullstackunoesc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.desafiofullstackunoesc.entities.MunicipioEntity;


@Repository
public interface MunicipioRepository extends JpaRepository<MunicipioEntity, Long> {

}

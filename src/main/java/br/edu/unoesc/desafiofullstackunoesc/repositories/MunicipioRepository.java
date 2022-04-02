package br.edu.unoesc.desafiofullstackunoesc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.desafiofullstackunoesc.entities.MunicipioEntity;


@Repository
public interface MunicipioRepository extends JpaRepository<MunicipioEntity, Long> {
    @Query(value = "select * from municipio where codigoIBGE = :codigoIBGE ", nativeQuery = true)
    public MunicipioEntity verifica(String codigoIBGE);
}

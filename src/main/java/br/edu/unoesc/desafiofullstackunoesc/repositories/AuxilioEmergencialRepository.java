package br.edu.unoesc.desafiofullstackunoesc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.desafiofullstackunoesc.models.AuxilioEmergencial;

@Repository
public interface AuxilioEmergencialRepository extends JpaRepository<AuxilioEmergencial, Long>{
    
}

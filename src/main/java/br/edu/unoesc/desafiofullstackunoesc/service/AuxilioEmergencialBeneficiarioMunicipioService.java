package br.edu.unoesc.desafiofullstackunoesc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.unoesc.desafiofullstackunoesc.models.AuxilioEmergencial;
import reactor.core.publisher.Mono;

@Service
public class AuxilioEmergencialBeneficiarioMunicipioService {
    
    @Autowired
    private WebClient webClient;

    public AuxilioEmergencial obterAuxilioPorMunicipio(String codigoIbge, int mesAno, int pagina){

        Mono<AuxilioEmergencial> monoAuxilio = this.webClient.method(HttpMethod.GET).uri("/auxilio-emergencial-beneficiario-por-municipio?codigoIbge={codigoIbge}&mesAno={mesAno}&pagina={1}").retrieve().bodyToMono(AuxilioEmergencial.class);
        
        // monoAuxilio.subscribe((t) -> {
        //     System.out.println("Finalizou");
        // });

        AuxilioEmergencial auxilio = monoAuxilio.block();
        
        return auxilio;
    }
}

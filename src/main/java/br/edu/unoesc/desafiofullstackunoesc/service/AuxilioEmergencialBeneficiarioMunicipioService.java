package br.edu.unoesc.desafiofullstackunoesc.service;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;


@Service
public class AuxilioEmergencialBeneficiarioMunicipioService {
    
    //@Autowired
    //private WebClient webClient;

    public void obterAuxilioPorMunicipio(String codigoIbge, int mesAno, int pagina) throws IOException{

        URL url = new URL("https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio?codigoIbge=4209003&mesAno=202011&pagina=1");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        connection.setRequestProperty("Accept", "application/json");

        connection.setRequestProperty("chave-api-dados", "634d7ef9135b36b36ed3223f9eb6eb10");


        BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String output;

        while ((output = buffer.readLine()) != null) {

            System.out.println(output);

        }        

        // ObjectMapper objectMapper = new ObjectMapper();
        // AuxilioApi data = objectMapper.readValue(output);


        connection.disconnect();
    }
}

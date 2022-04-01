package br.edu.unoesc.desafiofullstackunoesc.service;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import br.edu.unoesc.desafiofullstackunoesc.helpers.ChaveApiDados;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;


@Service
public class AuxilioEmergencialBeneficiarioMunicipioService {
    
    //@Autowired
    //private WebClient webClient;

    public void obterAuxilioPorMunicipio(String codigoIbge, int mesAno) throws IOException, JSONException{

        URL url = new URL("https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio?codigoIbge="+codigoIbge+"&mesAno=" + mesAno+"&pagina=1");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        connection.setRequestProperty("Accept", "application/json");

        connection.setRequestProperty("chave-api-dados", ChaveApiDados.chaveApiDados);


        BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String output;

        StringBuilder jsonString = new StringBuilder();

        while ((output = buffer.readLine()) != null) {

            jsonString.append(output);

        }        

        JSONObject jsonObj = new JSONObject(jsonString.toString());
        System.out.println(jsonString);
        System.out.println("---------------------------");
        System.out.println(jsonObj);


        connection.disconnect();
    }
}

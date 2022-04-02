package br.edu.unoesc.desafiofullstackunoesc.service;

import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.hibernate.validator.internal.engine.groups.ValidationOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import br.edu.unoesc.desafiofullstackunoesc.entities.AuxilioEmergencialEntity;
import br.edu.unoesc.desafiofullstackunoesc.entities.MunicipioEntity;
import br.edu.unoesc.desafiofullstackunoesc.entities.UnidadeFederativaEntity;
import br.edu.unoesc.desafiofullstackunoesc.helpers.ChaveApiDados;
import br.edu.unoesc.desafiofullstackunoesc.helpers.ConvertJsonToString;
import br.edu.unoesc.desafiofullstackunoesc.models.AuxilioEmergencialModel;
import br.edu.unoesc.desafiofullstackunoesc.models.MunicipioModel;
import br.edu.unoesc.desafiofullstackunoesc.models.UfModel;
import br.edu.unoesc.desafiofullstackunoesc.repositories.AuxilioEmergencialRepository;
import br.edu.unoesc.desafiofullstackunoesc.repositories.MunicipioRepository;
import br.edu.unoesc.desafiofullstackunoesc.repositories.UnidadeFederativaRepository;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;


@Service
public class AuxilioEmergencialBeneficiarioMunicipioService {
    
    @Autowired
    private UnidadeFederativaRepository ufRepo;
    @Autowired
    private MunicipioRepository municipioRepo;
    @Autowired
    private AuxilioEmergencialRepository auxilioRepo;
    @Autowired
    private ArquivoCsvService arquivoCsv;



    float valorTotal1 = 0;
    float valorTotal2 = 0;
    float valorTotal3 = 0;
    float valorTotal4 = 0;
    float valorTotal5 = 0;
    float valorTotal6 = 0;
    float valorTotal7 = 0;
    float valorTotal8 = 0;

    public void obterAuxilioPorMunicipio(String codigoIbge, int mesAno) throws IOException, JSONException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException{

        Type collectionType = new TypeToken<List<AuxilioEmergencialModel>>() {
        }.getType();
        List<AuxilioEmergencialModel> listAux = new Gson()
                .fromJson("", collectionType);

        int pagina = 1;
        // while(pagina != 100){
            URL url = new URL("https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio?codigoIbge="+codigoIbge+"&mesAno=" + mesAno+"&pagina="+ 1);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            connection.setRequestProperty("Accept", "application/json");

            connection.setRequestProperty("chave-api-dados", ChaveApiDados.chaveApiDados);    
            
            
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            String jsonEmString = ConvertJsonToString.converte(buffer);

            if(jsonEmString != ""){
                listAux = new Gson()
                        .fromJson(jsonEmString, collectionType);

                System.out.println(listAux);

                for(int i = 0; i < listAux.size(); i++){                    
                    switch (listAux.get(i).getNumeroParcela()) {
                        case "1ª":
                            valorTotal1 += listAux.get(i).getValor();
                            System.out.println(valorTotal1);
                            break;
                        case "2ª":
                            valorTotal2 += listAux.get(i).getValor();
                            break;
                        case "3ª":
                            valorTotal3 += listAux.get(i).getValor();
                            break;
                        case "4ª":
                            valorTotal4 += listAux.get(i).getValor();
                            break;
                        case "5ª":
                            valorTotal5 += listAux.get(i).getValor();
                            break;
                        case "6ª":
                            valorTotal6 += listAux.get(i).getValor();
                            break;
                        case "7ª":
                            valorTotal7 += listAux.get(i).getValor();
                            break;
                        case "8ª":
                            valorTotal8 += listAux.get(i).getValor();
                            break;
                    }
                }
                connection.disconnect();

                saveUf(listAux.get(1).getMunicipio().getUf());
                saveMunicipio(listAux.get(1).getMunicipio());
                


                pagina++;
            }
            
            // }
            int aux1 = 0;
            int aux2 = 0;
            int aux3 = 0;
            int aux4 = 0;
            int aux5 = 0;
            int aux6 = 0;
            int aux7 = 0;
            int aux8 = 0;

            List<AuxilioEmergencialEntity> listAuxilio = new ArrayList<AuxilioEmergencialEntity>();

            for (int i = 0; i < listAux.size(); i++) {
                if (valorTotal1 != 0 && aux1 == 0) {
                    listAux.get(i).setNumeroParcela("1ª");
                    AuxilioEmergencialEntity aux = saveAuxilio(listAux.get(i), valorTotal1, mesAno);
                    listAuxilio.add(aux);
                    aux1 = 1;
                } else if (valorTotal2 != 0 && aux2 == 0) {
                    listAux.get(i).setNumeroParcela("2ª");
                    AuxilioEmergencialEntity aux = saveAuxilio(listAux.get(i), valorTotal2, mesAno);
                    listAuxilio.add(aux);
                    aux2 = 1;
                } else if (valorTotal3 != 0 && aux3 == 0) {
                    listAux.get(i).setNumeroParcela("3ª");
                    AuxilioEmergencialEntity aux = saveAuxilio(listAux.get(i), valorTotal3, mesAno);
                    listAuxilio.add(aux);
                    aux3 = 1;
                } else if (valorTotal4 != 0 && aux4 == 0) {
                    listAux.get(i).setNumeroParcela("4ª");
                    AuxilioEmergencialEntity aux = saveAuxilio(listAux.get(i), valorTotal4, mesAno);
                    listAuxilio.add(aux);
                    aux4 = 1;
                } else if (valorTotal5 != 0 && aux5 == 0) {
                    listAux.get(i).setNumeroParcela("5ª");
                    AuxilioEmergencialEntity aux = saveAuxilio(listAux.get(i), valorTotal5, mesAno);
                    listAuxilio.add(aux);
                    aux5 = 1;
                } else if (valorTotal6 != 0 && aux6 == 0) {
                    listAux.get(i).setNumeroParcela("6ª");
                    AuxilioEmergencialEntity aux = saveAuxilio(listAux.get(i), valorTotal6, mesAno);
                    listAuxilio.add(aux);
                    aux6 = 1;
                } else if (valorTotal7 != 0 && aux7 == 0) {
                    listAux.get(i).setNumeroParcela("7ª");
                    AuxilioEmergencialEntity aux = saveAuxilio(listAux.get(i), valorTotal7, mesAno);
                    listAuxilio.add(aux);
                    aux7 = 1;
                } else if (valorTotal8 != 0 && aux8 == 0) {
                    listAux.get(i).setNumeroParcela("8ª");
                    AuxilioEmergencialEntity aux = saveAuxilio(listAux.get(i), valorTotal8, mesAno);
                    listAuxilio.add(aux);
                    aux8 = 1;
                }
         };

         ArquivoCsvService.criarCsv(listAuxilio);
    }

    public void saveUf(UfModel uf){
        UnidadeFederativaEntity ufexiste = ufRepo.verifica(uf.getNome());

        if(ufexiste == null){
            UnidadeFederativaEntity newUf = new UnidadeFederativaEntity();
            newUf.setNome(uf.getNome());
            newUf.setSigla(uf.getSigla());

            ufRepo.save(newUf);
        }
        
    }

    public void saveMunicipio(MunicipioModel municipio) {
        MunicipioEntity muniExiste = municipioRepo.verifica(municipio.getCodigoIBGE());

        if (muniExiste == null) {
            MunicipioEntity newMunicipio = new MunicipioEntity();
            newMunicipio.setCodigoIBGE(Long.parseLong(municipio.getCodigoIBGE()));
            newMunicipio.setCodigoRegiao(municipio.getCodigoRegiao());
            newMunicipio.setNomeIBGE(municipio.getNomeIBGE());
            newMunicipio.setPais(municipio.getPais());
            UnidadeFederativaEntity ufexiste = ufRepo.verifica(municipio.getUf().getNome());
            newMunicipio.setUnidadeFederativa(ufexiste);

            municipioRepo.save(newMunicipio);
        }

    }

    public AuxilioEmergencialEntity saveAuxilio(AuxilioEmergencialModel auxilio, float valor, int mesAno) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException{
        AuxilioEmergencialEntity newEntity = new AuxilioEmergencialEntity();

        newEntity.setNumeroParcela(auxilio.getNumeroParcela());
        newEntity.setValorTotal(new BigDecimal(Float.toString(valor)));
        newEntity.setDataConsulta(new Date());
        MunicipioEntity muni =  municipioRepo.verifica(auxilio.getMunicipio().getCodigoIBGE());
        newEntity.setMunicipio(muni);


        AuxilioEmergencialEntity auxilios = auxilioRepo.save(newEntity);

        return auxilios;

    }
}



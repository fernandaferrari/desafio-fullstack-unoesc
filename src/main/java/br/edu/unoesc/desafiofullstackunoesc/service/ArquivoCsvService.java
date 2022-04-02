package br.edu.unoesc.desafiofullstackunoesc.service;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.springframework.stereotype.Service;

import br.edu.unoesc.desafiofullstackunoesc.entities.AuxilioEmergencialEntity;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArquivoCsvService {

    public static void criarCsv(List<AuxilioEmergencialEntity> auxilio)
            throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        String[] cabecalho = { "Nome Cidade", "Parcela nº", "Valor Total", "Data Consulta"};
        Writer writer = Files.newBufferedWriter(Paths.get("/home/fernanda/Downloads/auxilio.csv"));
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeNext(cabecalho);

        for(int i=0; i< auxilio.size(); i++){
            List<String[]> linhas = new ArrayList<>();
            linhas.add(new String[] { auxilio.get(i).getMunicipio().getNomeIBGE(), auxilio.get(i).getNumeroParcela(),
                    auxilio.get(i).getValorTotal().toString(), auxilio.get(1).getDataConsulta().toString()});            
            csvWriter.writeAll(linhas);
        }        

        csvWriter.flush();
        writer.close();

    }

}

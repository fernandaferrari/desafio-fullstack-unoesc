package br.edu.unoesc.desafiofullstackunoesc.service;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
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

    public static void criarCsv(AuxilioEmergencialEntity auxilio)
            throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        List<AuxilioEmergencialEntity> auxilios = new ArrayList<>();
        auxilios.add(auxilio);

        Writer writer = Files.newBufferedWriter(Paths.get("auxilios.csv"));
        StatefulBeanToCsv<AuxilioEmergencialEntity> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

        beanToCsv.write(auxilios);

        writer.flush();
        writer.close();

        // String[] cabecalho = { "Nome Cidade", "Parcela nº", "Valor Total" };

        // List<String[]> linhas = new ArrayList<>();
        // linhas.add(new String[] { auxilio.getMunicipio().toString(), auxilio.getNumeroParcela(), auxilio.getValorTotal().toString() });

        // Writer writer = Files.newBufferedWriter(Paths.get("pessoas.csv"));
        // CSVWriter csvWriter = new CSVWriter(writer);

        // csvWriter.writeNext(cabecalho);
        // csvWriter.writeAll(linhas);

        // csvWriter.flush();
        // writer.close();

    }

}

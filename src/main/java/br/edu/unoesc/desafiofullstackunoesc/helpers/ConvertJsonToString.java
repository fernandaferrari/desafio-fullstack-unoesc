package br.edu.unoesc.desafiofullstackunoesc.helpers;

import java.io.BufferedReader;
import java.io.IOException;

public class ConvertJsonToString {
    public static String converte(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
}

package br.edu.unoesc.desafiofullstackunoesc.helpers;

public class ConvertData {
    public static int converter(String mesAno){
        String ano = mesAno.substring(0, 4);
        String mes = mesAno.substring(5,7);

        return Integer.parseInt(ano+mes);
    }

    public static String format(String mesAno) {
        String ano = mesAno.substring(0, 4);
        String mes = mesAno.substring(5, 7);

        return "00-"+mes+"-"+ano;
    }
}

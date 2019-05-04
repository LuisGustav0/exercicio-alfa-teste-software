package br.com.gilmarioarantes.jdbccrudv1.util;

import java.util.Random;

public class GeraData {

    public static String geraData(){
        String result = "";
        Random random = new Random();
        int minimo = 1;
        int diaMaximo = 31;
        int mesMaximo = 12;
        int dia;
        int mes = random.nextInt((mesMaximo - minimo)+1) + 1;
        if(mes == 2){
            diaMaximo = 28;
        }else if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
            diaMaximo = 30;
        }

        dia = random.nextInt((diaMaximo - minimo) + 1) + 1;


        int idade = random.nextInt((70) + 1) + 1;
        if(idade < 16){
            idade += 16;
        }
        int anoCorrente = 2019;
        int anoNascimento = anoCorrente-idade;

        if(dia < 10 || mes < 10) {
            if(dia < 10){
                result = "0"+dia + "/" + mes + "/" + anoNascimento;
                if(mes < 10){
                    result = "0"+dia + "/0" + mes + "/" + anoNascimento;
                }
            }else if(mes < 10){
                result = dia + "/0" + mes + "/" + anoNascimento;
            }
        }else{
            result = dia + "/" + mes + "/" + anoNascimento;
        }

        return result;
    }

}

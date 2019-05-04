package br.com.gilmarioarantes.jdbccrudv1.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormataData {

    private DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public String dateToString(Date data){
        String dataFormatada;
        return sdf.format(data);
    }

    public Date stringToDate(String data){
        Date dataFormatada = null;
        try{
            dataFormatada =  sdf.parse(data);
        }catch (ParseException pe){
            pe.printStackTrace();
        }
        return dataFormatada;
    }

    public Timestamp stringToTimeStamp(String data){
        Date date = stringToDate(data);
        Timestamp ts = new Timestamp(date.getTime());
        return ts;
    }

    public String timeStampToString(Timestamp timestamp){
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatter.format(timestamp);
        return dataFormatada;
    }

    public static void main(String args[]){

        FormataData app = new FormataData();

        String data = "25/01/1977";

        Timestamp timestamp = app.stringToTimeStamp(data);

        //Date date = new Date();
        //Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(timestamp));
    }

}

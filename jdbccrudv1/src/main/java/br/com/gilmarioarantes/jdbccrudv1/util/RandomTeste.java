package br.com.gilmarioarantes.jdbccrudv1.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class RandomTeste{

    public static void main(String args[]){
        int i = new Random().nextInt(4)+1;
        System.out.println(i);
    }


}

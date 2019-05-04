package br.com.gilmarioarantes.jdbccrudv1.util;

import java.util.Random;

public class GeraNota {

    public static double geraNota(){
       // Random random = new Random();
        return new Random().nextDouble()*10;
    }

}

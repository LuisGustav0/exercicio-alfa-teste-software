package br.com.gilmarioarantes.jdbccrudv1.persistencia.base;

import br.com.gilmarioarantes.jdbccrudv1.exceptions.InvalidDataBaseTypeException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {

    //JDBC driver name
    public static final String JDBC_DRIVER = "org.h2.Driver";

    //Database file URL
    public static final String DB_FILE_URL = "jdbc:h2:~/aluno";

    //Database memory URL
    public static final String DB_MEMORY_URL = "jdbc:h2:mem:testdb";

    //Database Credentials
    public static final String USER = "sa";
    public static final String PASS = "";

    private Connection conn = null;

    public Connection getConnection(String connectionType) throws InvalidDataBaseTypeException {
        try {
            //STEP 1: Register JDBC Driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            if (!connectionType.equalsIgnoreCase("file") && !connectionType.equalsIgnoreCase("memory")){
                throw new InvalidDataBaseTypeException("O tipo do banco de dados deve ser [file] ou [memory].");
            }else if (connectionType.equalsIgnoreCase("file")) {
                conn = DriverManager.getConnection(DB_FILE_URL, USER, PASS);
            }else{
                conn = DriverManager.getConnection(DB_MEMORY_URL, USER, PASS);
            }
        }catch (SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch (Exception e){
            //Handle errors for Class.forName.
            e.printStackTrace();
        } //end try
        return conn;
    }
}

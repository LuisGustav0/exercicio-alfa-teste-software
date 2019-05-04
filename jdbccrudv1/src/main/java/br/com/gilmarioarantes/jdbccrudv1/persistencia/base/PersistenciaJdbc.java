package br.com.gilmarioarantes.jdbccrudv1.persistencia.base;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Statement;

public class PersistenciaJdbc {
    protected Connection connection = null;
    protected Statement stmt = null;
    protected CriaConexao criaConexao = new CriaConexao();
    protected String connectionType = "file";

    protected void preparaPersistencia() throws Exception{

        //STEP 3: Open a connection
        connection = criaConexao.getConnection(connectionType);


        //STEP 4: Execute a SQL statement
        stmt = connection.createStatement();

    }
}

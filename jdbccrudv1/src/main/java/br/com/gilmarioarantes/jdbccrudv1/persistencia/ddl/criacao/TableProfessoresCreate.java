package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.criacao;


import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class TableProfessoresCreate extends PersistenciaJdbc {

    static Logger logger = Logger.getLogger(TableProfessoresCreate.class.getName());

    public boolean criaTabela() throws Exception{

        preparaPersistencia();

        logger.info("Criando a tabela Professores");

        String sql = "CREATE TABLE IF NOT EXISTS PROFESSORES(\n" +
                "ID_PROFESSOR LONG NOT NULL PRIMARY KEY,\n" +
                "NOME VARCHAR(100) NOT NULL,\n" +
                "EMAIL VARCHAR(30) NOT NULL," +
                "TITULACAO VARCHAR(20)" +
                ")";

        stmt.executeUpdate(sql);

        logger.info("Tabela Professores criada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();

        return true;
    }

}

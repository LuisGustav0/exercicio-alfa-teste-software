package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.criacao;


import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class TableCursosCreate extends PersistenciaJdbc {

    static Logger logger = Logger.getLogger(TableCursosCreate.class.getName());

    public boolean criaTabela() throws Exception{

        preparaPersistencia();

        logger.info("Criando a tabela Cursos");

        String sql = "CREATE TABLE IF NOT EXISTS CURSOS(\n" +
                "ID_CURSO LONG NOT NULL PRIMARY KEY,\n" +
                "NOME VARCHAR(100) NOT NULL\n" +
                ")";

        stmt.executeUpdate(sql);

        logger.info("Tabela Cursos criada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

}

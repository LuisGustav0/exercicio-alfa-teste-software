package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.criacao;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class TableDisciplinasCreate extends PersistenciaJdbc {

    static Logger logger = Logger.getLogger(TableDisciplinasCreate.class.getName());

    public boolean criaTabela() throws Exception{

        preparaPersistencia();

        logger.info("Criando a Tabela Disciplinas");

        String sql = "CREATE TABLE IF NOT EXISTS DISCIPLINAS(\n" +
                "ID_DISCIPLINA LONG NOT NULL PRIMARY KEY,\n" +
                "NOME VARCHAR(100) NOT NULL,\n" +
                "CARGA_HORARIA DECIMAL(6,2) NOT NULL," +
                "CURSO LONG NOT NULL" +
                ")";

        stmt.executeUpdate(sql);

        logger.info("Tabela Disciplinas criada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();

        return true;
    }
}

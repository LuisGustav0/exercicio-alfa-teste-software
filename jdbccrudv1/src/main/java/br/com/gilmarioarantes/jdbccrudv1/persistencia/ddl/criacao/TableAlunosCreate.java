package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.criacao;


import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class TableAlunosCreate extends PersistenciaJdbc {

    static Logger logger = Logger.getLogger(TableAlunosCreate.class.getName());

    public boolean criaTabela() throws Exception{

        preparaPersistencia();

        logger.info("Criando a tabela Alunos");

        String sql = "CREATE TABLE IF NOT EXISTS ALUNOS(\n" +
                "ID_ALUNO LONG NOT NULL PRIMARY KEY,\n" +
                "MATRICULA VARCHAR(15) NOT NULL UNIQUE," +
                "NOME VARCHAR(100) NOT NULL UNIQUE," +
                "SEXO VARCHAR(10) NOT NULL," +
                "DATA_NASCIMENTO TIMESTAMP NOT NULL" +
                ")";

        stmt.executeUpdate(sql);

        logger.info("Tabela Alunos criada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

}

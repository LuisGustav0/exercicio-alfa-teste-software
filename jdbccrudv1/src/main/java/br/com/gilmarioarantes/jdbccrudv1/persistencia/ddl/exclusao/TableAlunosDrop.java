package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.exclusao;


import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class TableAlunosDrop extends PersistenciaJdbc {

    static Logger logger = Logger.getLogger(TableAlunosDrop.class.getName());

    public boolean excluiTabela() throws Exception{

        preparaPersistencia();

        logger.info("Excluindo a tabela Alunos");

        String sql = "DROP TABLE IF EXISTS ALUNOS";

        stmt.executeUpdate(sql);

        logger.info("Tabela Alunos excluida com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

}

package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.exclusao;


import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class TableTurmasDrop extends PersistenciaJdbc {

    static Logger logger = Logger.getLogger(TableTurmasDrop.class.getName());

    public boolean excluiTabela() throws Exception{

        preparaPersistencia();

        logger.info("Excluindo a tabela Turmas");

        String sql = "DROP TABLE IF EXISTS TURMAS";

        stmt.executeUpdate(sql);

        logger.info("Tabela Turmas excluida com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();

        return true;
    }

}

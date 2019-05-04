package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.exclusao;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class TableDisciplinasDrop extends PersistenciaJdbc {

    static Logger logger = Logger.getLogger(TableDisciplinasDrop.class.getName());

    public boolean excluiTabela() throws Exception{

        preparaPersistencia();

        logger.info("Excluindo a Tabela Disciplinas");

        String sql = "DROP TABLE IF EXISTS DISCIPLINAS";

        stmt.executeUpdate(sql);

        logger.info("Tabela Disciplinas excluida com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();

        return true;
    }
}

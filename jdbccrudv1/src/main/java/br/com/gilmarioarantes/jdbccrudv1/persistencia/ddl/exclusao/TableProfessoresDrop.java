package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.exclusao;


import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class TableProfessoresDrop extends PersistenciaJdbc {

    static Logger logger = Logger.getLogger(TableProfessoresDrop.class.getName());

    public boolean excluiTabela() throws Exception{

        preparaPersistencia();

        logger.info("Excluindo a tabela Professores");

        String sql = "DROP TABLE IF EXISTS PROFESSORES";

        stmt.executeUpdate(sql);

        logger.info("Tabela Professores excluida com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();

        return true;
    }

}

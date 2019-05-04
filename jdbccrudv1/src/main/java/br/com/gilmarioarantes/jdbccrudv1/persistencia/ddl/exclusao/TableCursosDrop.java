package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.exclusao;


import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class TableCursosDrop extends PersistenciaJdbc {

    static Logger logger = Logger.getLogger(TableCursosDrop.class.getName());

    public boolean excluiTabela() throws Exception{

        preparaPersistencia();

        logger.info("Excluindo a tabela Cursos");

        String sql = "DROP TABLE IF EXISTS CURSOS";

        stmt.executeUpdate(sql);

        logger.info("Tabela Cursos excluida com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();

        return true;
    }

}

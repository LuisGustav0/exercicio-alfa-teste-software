package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class AdicionaFKTabelaDisciplinas extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(AdicionaFKTabelaDisciplinas.class.getName());

    public boolean alteraTabela() throws Exception{

        preparaPersistencia();

        logger.info("Alterando a Tabela Disciplinas");

        String sql = "ALTER TABLE DISCIPLINAS " +
                "ADD FOREIGN KEY (CURSO) REFERENCES CURSOS(ID_CURSO) ON DELETE CASCADE";

        stmt.executeUpdate(sql);

        logger.info("Tabela Disciplinas alterada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}

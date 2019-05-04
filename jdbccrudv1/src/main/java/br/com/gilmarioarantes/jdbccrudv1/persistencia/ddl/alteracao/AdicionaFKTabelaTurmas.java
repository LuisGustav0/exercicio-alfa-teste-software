package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class AdicionaFKTabelaTurmas extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(AdicionaFKTabelaTurmas.class.getName());

    public boolean alteraTabela() throws Exception{

        preparaPersistencia();

        logger.info("Alterando a Tabela Turmas");

        String sql = "ALTER TABLE TURMAS ADD FOREIGN KEY (DISCIPLINA) REFERENCES DISCIPLINAS(ID_DISCIPLINA) ON DELETE CASCADE;\n" +
                " ALTER TABLE TURMAS ADD FOREIGN KEY (PROFESSOR) REFERENCES PROFESSORES(ID_PROFESSOR) ON DELETE CASCADE;";

        stmt.executeUpdate(sql);

        logger.info("Tabela Turmas alterada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}

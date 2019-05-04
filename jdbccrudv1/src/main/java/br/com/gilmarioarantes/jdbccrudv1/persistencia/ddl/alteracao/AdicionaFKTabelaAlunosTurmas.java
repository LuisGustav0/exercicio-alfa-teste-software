package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class AdicionaFKTabelaAlunosTurmas extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(AdicionaFKTabelaAlunosTurmas.class.getName());

    public boolean alteraTabela() throws Exception{

        preparaPersistencia();

        logger.info("Alterando a Tabela Alunos_Turmas");

        String sql = "ALTER TABLE ALUNOS_TURMAS ADD FOREIGN KEY (TURMA) REFERENCES TURMAS(ID_TURMA) ON DELETE CASCADE;\n" +
                " ALTER TABLE ALUNOS_TURMAS ADD FOREIGN KEY (ALUNO) REFERENCES ALUNOS(ID_ALUNO) ON DELETE CASCADE;\n";

        stmt.executeUpdate(sql);

        logger.info("Tabela Alunos_Turmas alterada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}

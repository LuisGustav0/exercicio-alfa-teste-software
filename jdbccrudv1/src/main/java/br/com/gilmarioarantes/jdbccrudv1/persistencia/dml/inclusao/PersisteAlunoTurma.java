package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.AlunoTurma;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class PersisteAlunoTurma extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(PersisteAlunoTurma.class.getName());

    public boolean persisteAlunoTurma(AlunoTurma alunoTurma) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO ALUNOS_TURMAS(ID_ALUNOS_TURMAS, ALUNO, TURMA)  " +
                "VALUES('" + alunoTurma.getId() +
                "','" + alunoTurma.getAluno().getId() +
                "','" + alunoTurma.getTurma().getId() +
                "')";

        stmt.executeUpdate(sql);

        logger.info("A Turma foi persistida corretamente!");

        stmt.close();
        connection.close();

        return true;
    }
}

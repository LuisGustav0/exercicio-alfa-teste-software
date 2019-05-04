package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Turma;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class PersisteTurma extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(PersisteTurma.class.getName());

    public boolean persisteTurma(Turma turma) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO TURMAS " +
                "VALUES('" + turma.getId() +
                "','" + turma.getSemestre() +
                "','" + turma.getDisciplina().getId() +
                "','" + turma.getProfessor().getId() +
                "')";

        stmt.executeUpdate(sql);

        logger.info("A Turma foi persistida corretamente!");

        stmt.close();
        connection.close();

        return true;
    }
}

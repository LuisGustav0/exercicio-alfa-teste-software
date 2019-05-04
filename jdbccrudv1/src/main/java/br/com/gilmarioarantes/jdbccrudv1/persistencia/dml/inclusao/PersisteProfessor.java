package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Professor;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class PersisteProfessor extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(PersisteProfessor.class.getName());

    public boolean persisteProfessor(Professor professor) throws Exception{

        logger.info("Executando o método persisteProfessor() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "INSERT INTO PROFESSORES " +
                "VALUES('" + professor.getId() +
                "','" + professor.getNome() +
                "','" + professor.getEmail() +
                "','" + professor.getTitulacao() +
                "')";

        stmt.executeUpdate(sql);
        logger.info("O Professor [" + professor.getNome() + "] foi persistido corretamente!");
        stmt.close();
        connection.close();

        return true;

    }
}

package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Curso;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class PersisteCurso extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(PersisteCurso.class.getName());

    public boolean persisteCurso(Curso curso) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO CURSOS " +
                "VALUES('" + curso.getId() +
                "','" + curso.getNome() +
                "')";

        stmt.executeUpdate(sql);
        logger.info("O Curso [" + curso.getNome() + "] foi persistido corretamente!");
        stmt.close();
        connection.close();

        return true;
    }

}

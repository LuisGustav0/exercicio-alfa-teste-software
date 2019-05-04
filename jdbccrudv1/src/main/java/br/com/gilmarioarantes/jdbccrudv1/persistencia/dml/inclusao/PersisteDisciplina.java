package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Disciplina;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

public class PersisteDisciplina extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(PersisteDisciplina.class.getName());

    public boolean persisteDisciplina(Disciplina disciplina) throws Exception{

        logger.info("Executando o método persisteDisciplina() da classe; " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "INSERT INTO DISCIPLINAS " +
                "VALUES('" + disciplina.getId() +
                "','" + disciplina.getNome() +
                "','" + disciplina.getCargaHoraria() +
                "','" + disciplina.getCurso().getId() +
                "')";

        stmt.executeUpdate(sql);
        logger.info("A Disciplina [" + disciplina.getNome() + "] foi persistida corretamente!");
        stmt.close();
        connection.close();

        return true;
    }
}

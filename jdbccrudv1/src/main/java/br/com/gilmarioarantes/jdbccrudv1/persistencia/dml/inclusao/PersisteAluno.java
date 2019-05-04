package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.gilmarioarantes.jdbccrudv1.util.FormataData;
import org.apache.log4j.Logger;

public class PersisteAluno extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(PersisteAluno.class.getName());

    public boolean persisteAluno(Aluno aluno) throws Exception{

        preparaPersistencia();

        String sql = "INSERT INTO ALUNOS " +
                "VALUES('" + aluno.getId() +
                "','" + aluno.getMatricula() +
                "','" + aluno.getNome() +
                "','" + aluno.getSexo() +
                "','" + aluno.getDataNascimento() +
                "')";

        stmt.executeUpdate(sql);
        if(aluno.getSexo().equalsIgnoreCase("MASCULINO")){
            logger.info("O Aluno [" + aluno.getNome() + "] foi persistido corretamente.");
        }else{
            logger.info("A Aluna [" + aluno.getNome() + "] foi persistida corretamente.");
        }

        stmt.close();
        connection.close();

        return true;
    }
}

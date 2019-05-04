package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.model.Disciplina;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;

public class AlteraDisciplina extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(AlteraDisciplina.class.getName());

    public boolean alteraNome(Disciplina disciplina) throws Exception{
        logger.info("Executando o método alteraNome() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE DISCIPLINAS SET NOME = ? WHERE ID_DISCIPLINA = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, disciplina.getNome());
        pstmt.setLong(2,disciplina.getId());

        pstmt.executeUpdate();

        logger.info("O Nome da disciplina [" + disciplina.getNome() + "]foi alterado corretamente!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }

    public boolean alteraCargaHoraria(Disciplina disciplina) throws Exception{
        logger.info("Executando o método alteraCargaHoraria() da classe: " + this.getClass().getSimpleName());
        preparaPersistencia();

        String sql = "UPDATE DISCIPLINAS SET CARGA_HORARIA = ? WHERE ID_DISCIPLINA = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setDouble(1, disciplina.getCargaHoraria());
        pstmt.setLong(2, disciplina.getId());

        pstmt.executeUpdate();

        logger.info("A carga horária da disciplina [" + disciplina.getNome() + "]foi alterada corretamente!");

        pstmt.close();
        stmt.close();
        connection.close();
        return true;
    }

    public boolean alteraCurso(Disciplina disciplina) throws Exception{
        logger.info("Executando o método alteraCurso() da classe: " + this.getClass().getSimpleName());
        preparaPersistencia();

        String sql = "UPDATE DISCIPLINAS SET CURSO = ? WHERE ID_DISCIPLINA = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,disciplina.getCurso().getId());
        pstmt.setLong(2,disciplina.getId());
        pstmt.executeUpdate();

        logger.info("O curso da disciplina [" + disciplina.getNome() + " ]foi alterado corretamente!");

        return true;
    }

}

package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.model.Turma;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;

public class AlteraTurma extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(AlteraTurma.class.getName());

    public boolean alteraSemestre(Turma turma)throws Exception{

        logger.info("Executando o método alteraSemestre() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE TURMAS SET SEMESTRE = ? WHERE ID_TURMA = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,turma.getSemestre());
        pstmt.setLong(2,turma.getId());

        pstmt.executeUpdate();

        logger.info("O semestre da turma foi alterado com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }

    public boolean alteraDisciplina(Turma turma)throws Exception{

        logger.info("Executando o método alteraDisciplina() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE TURMAS SET DISCIPLINA = ? WHERE ID_TURMA = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,turma.getDisciplina().getId());
        pstmt.setLong(2,turma.getId());

        pstmt.executeUpdate();

        logger.info("A Disciplina da turma foi alterada com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }

    public boolean alteraProfessor(Turma turma)throws Exception{

        logger.info("Executando o método alteraProfessor() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE TURMAS SET PROFESSOR = ? WHERE ID_TURMA = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,turma.getProfessor().getId());
        pstmt.setLong(2,turma.getId());

        pstmt.executeUpdate();

        logger.info("O Professor da turma foi alterado com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }
}

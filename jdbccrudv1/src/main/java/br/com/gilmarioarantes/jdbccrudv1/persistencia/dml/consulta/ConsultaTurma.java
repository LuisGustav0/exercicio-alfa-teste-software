package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta;

import br.com.gilmarioarantes.jdbccrudv1.model.Disciplina;
import br.com.gilmarioarantes.jdbccrudv1.model.Professor;
import br.com.gilmarioarantes.jdbccrudv1.model.Turma;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaTurma extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(ConsultaTurma.class.getName());

    public Turma consultaPorId(Long id) throws Exception{

        logger.info("Executanto o método consultaPorId() da classe: " + this.getClass().getSimpleName());

        Turma turma = new Turma();

        preparaPersistencia();

        String sql = "SELECT * FROM TURMAS WHERE ID_TURMA = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        ResultSet rs = pstmt.executeQuery(  );

        while(rs.next()){
            turma.setId(rs.getLong("ID_TURMA"));
            turma.setSemestre(rs.getString("SEMESTRE"));

            Disciplina disciplina = new Disciplina();
            disciplina.setId(rs.getLong("DISCIPLINA"));
            turma.setDisciplina(disciplina);

            Professor professor = new Professor();
            professor.setId(rs.getLong("PROFESSOR"));
            turma.setProfessor(professor);
        }

        logger.info("A consulta de turma por id foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return turma;
    }

    public int obtemQuantidadeTurmas() throws Exception{

        logger.info("Executanto o método obtemQuantidadeTurmas() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "SELECT COUNT(*) FROM TURMAS";

        int quantidadeTurmas = 0;

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()){
            quantidadeTurmas = rs.getInt(1);
        }

        rs.close();
        stmt.close();
        connection.close();

        return quantidadeTurmas;

    }

}

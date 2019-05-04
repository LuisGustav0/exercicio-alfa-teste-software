package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.model.AlunoTurma;
import br.com.gilmarioarantes.jdbccrudv1.model.Turma;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaAlunoTurma extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(ConsultaAlunoTurma.class.getName());

    public AlunoTurma consultaPorId(Long id) throws Exception{

        logger.info("Executanto o método consultaPorId() da classe: " + this.getClass().getSimpleName());

        AlunoTurma alunoTurma = new AlunoTurma();

        preparaPersistencia();

        String sql = "SELECT * FROM ALUNOS_TURMAS WHERE ID_ALUNOS_TURMAS = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        ResultSet rs = pstmt.executeQuery(  );

        while(rs.next()){
            alunoTurma.setId(rs.getLong("ID_ALUNOS_TURMAS"));
            alunoTurma.setNota1(rs.getDouble("NOTA1"));
            alunoTurma.setNota2(rs.getLong("NOTA2"));
            alunoTurma.setFrequencia(rs.getInt("FREQUENCIA"));
            alunoTurma.getAluno().setId(rs.getLong("ALUNO"));
            alunoTurma.getTurma().setId(rs.getLong("TURMA"));
        }

        logger.info("A consulta de AlunoTurma por id foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return alunoTurma;
    }

    public AlunoTurma consultaPorAluno(Aluno aluno) throws Exception{

        logger.info("Executanto o método consultaPorAluno() da classe: " + this.getClass().getSimpleName());

        AlunoTurma alunoTurma = new AlunoTurma();

        preparaPersistencia();

        String sql = "SELECT * FROM ALUNOS_TURMAS WHERE ALUNO = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,aluno.getId());

        ResultSet rs = pstmt.executeQuery(  );

        while(rs.next()){
            alunoTurma.setId(rs.getLong("ID_ALUNOS_TURMAS"));
            alunoTurma.setNota1(rs.getDouble("NOTA1"));
            alunoTurma.setNota2(rs.getLong("NOTA2"));
            alunoTurma.setFrequencia(rs.getInt("FREQUENCIA"));
            alunoTurma.getAluno().setId(rs.getLong("ALUNO"));
            alunoTurma.getTurma().setId(rs.getLong("TURMA"));
        }

        logger.info("A consulta de AlunoTurma por aluno foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return alunoTurma;
    }

    public AlunoTurma consultaPorTurma(Turma turma) throws Exception{

        logger.info("Executanto o método consultaPorTurma() da classe: " + this.getClass().getSimpleName());

        AlunoTurma alunoTurma = new AlunoTurma();

        preparaPersistencia();

        String sql = "SELECT * FROM ALUNOS_TURMAS WHERE TURMA = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,turma.getId());

        ResultSet rs = pstmt.executeQuery(  );

        while(rs.next()){
            alunoTurma.setId(rs.getLong("ID_ALUNOS_TURMAS"));
            alunoTurma.setNota1(rs.getDouble("NOTA1"));
            alunoTurma.setNota2(rs.getLong("NOTA2"));
            alunoTurma.setFrequencia(rs.getInt("FREQUENCIA"));
            alunoTurma.getAluno().setId(rs.getLong("ALUNO"));
            alunoTurma.getTurma().setId(rs.getLong("TURMA"));
        }

        logger.info("A consulta de AlunoTurma por turma foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return alunoTurma;
    }

    public int obtemQuantidadeAlunosTurmas() throws Exception{

        logger.info("Executanto o método obtemQuantidadeAlunosTurmas() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "SELECT COUNT(*) FROM ALUNOS_TURMAS";

        int quantidadeAlunosTurmas = 0;

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()){
            quantidadeAlunosTurmas = rs.getInt(1);
        }

        rs.close();
        stmt.close();
        connection.close();

        return quantidadeAlunosTurmas;

    }

}

package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.model.AlunoTurma;
import br.com.gilmarioarantes.jdbccrudv1.model.Turma;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;

public class AlteraAlunosTurmas extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(AlteraAlunosTurmas.class.getName());

    public boolean alteraNota1(AlunoTurma alunoTurma)throws Exception{

        logger.info("Executando o método alteraNota1() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE ALUNOS_TURMAS SET NOTA1 = ? WHERE ID_ALUNOS_TURMAS = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setDouble(1,alunoTurma.getNota1());
        pstmt.setLong(2,alunoTurma.getId());

        pstmt.executeUpdate();

        logger.info("A nota1 do Aluno na Turma foi alterada com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }

    public boolean alteraNota2(AlunoTurma alunoTurma)throws Exception{

        logger.info("Executando o método alteraNota2() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE ALUNOS_TURMAS SET NOTA2 = ? WHERE ID_ALUNOS_TURMAS = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setDouble(1,alunoTurma.getNota2());
        pstmt.setLong(2,alunoTurma.getId());

        pstmt.executeUpdate();

        logger.info("A Nota2 do Aluno na Turma foi alterada com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }

    public boolean alteraFrequencia(AlunoTurma alunoTurma)throws Exception{

        logger.info("Executando o método alteraFrequencia() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE ALUNOS_TURMAS SET FREQUENCIA = ? WHERE ID_ALUNOS_TURMAS = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,alunoTurma.getFrequencia());
        pstmt.setLong(2,alunoTurma.getId());

        pstmt.executeUpdate();

        logger.info("A Frequencia do Aluno na Turma foi alterada com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }

    public boolean alteraAluno(AlunoTurma alunoTurma)throws Exception{

        logger.info("Executando o método alteraAluno() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE ALUNOS_TURMAS SET ALUNO = ? WHERE ID_ALUNOS_TURMAS = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,alunoTurma.getAluno().getId());
        pstmt.setLong(2,alunoTurma.getId());

        pstmt.executeUpdate();

        logger.info("O Aluno na Turma foi alterado com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }

    public boolean alteraTurma(AlunoTurma alunoTurma)throws Exception{

        logger.info("Executando o método alteraTurma() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE ALUNOS_TURMAS SET TURMA = ? WHERE ID_ALUNOS_TURMAS = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,alunoTurma.getTurma().getId());
        pstmt.setLong(2,alunoTurma.getId());

        pstmt.executeUpdate();

        logger.info("A Turma na Associação Aluno/Turma foi alterada com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }
}

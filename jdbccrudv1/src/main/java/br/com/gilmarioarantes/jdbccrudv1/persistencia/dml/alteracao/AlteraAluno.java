package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;

import java.sql.PreparedStatement;

public class AlteraAluno extends PersistenciaJdbc {

    public boolean alteraNome(Aluno aluno) throws Exception{

        preparaPersistencia();

        String sql = "UPDATE ALUNOS SET NOME = ? WHERE ID_ALUNO = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,aluno.getNome());
        pstmt.setLong(2, aluno.getId());

        pstmt.executeUpdate();

        System.out.println("O Nome do Aluno [" + aluno.getNome() + "] foi alterado com Sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;

    }

    public boolean alteraMatricula(Aluno aluno) throws Exception{

        preparaPersistencia();

        String sql = "UPDATE ALUNOS SET MATRICULA = ? WHERE ID_ALUNO = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,aluno.getMatricula());
        pstmt.setLong(2, aluno.getId());

        pstmt.executeUpdate();

        System.out.println("A Matrícula do Aluno [" + aluno.getNome() + "] foi alterada com Sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }

    public boolean alteraSexo(Aluno aluno) throws Exception{

        preparaPersistencia();

        String sql = "UPDATE ALUNOS SET SEXO = ? WHERE ID_ALUNO = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,aluno.getSexo());
        pstmt.setLong(2, aluno.getId());

        pstmt.executeUpdate();

        System.out.println("O sexo do Aluno [" + aluno.getNome() + "] foi alterado com Sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }

    public boolean alteraDataNascimento(Aluno aluno) throws Exception{

        preparaPersistencia();

        String sql = "UPDATE ALUNOS SET DATA_NASCIMENTO = ? WHERE ID_ALUNO = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setTimestamp(1,aluno.getDataNascimento());
        pstmt.setLong(2, aluno.getId());

        pstmt.executeUpdate();

        System.out.println("\nA data de nascimento do Aluno [" + aluno.getNome() + "] foi alterada com Sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }
}

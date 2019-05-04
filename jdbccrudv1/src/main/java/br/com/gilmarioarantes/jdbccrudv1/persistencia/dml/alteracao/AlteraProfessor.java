package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.model.Professor;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;

public class AlteraProfessor extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(AlteraProfessor.class.getName());

    public boolean alteraNome(Professor professor) throws Exception{
        logger.info("Executando o método alteraNome() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE PROFESSORES SET NOME = ? WHERE ID_PROFESSOR = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, professor.getNome());
        pstmt.setLong(2,professor.getId());

        pstmt.executeUpdate();

        logger.info("O nome do professor foi alterado com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }

    public boolean alteraEmail(Professor professor) throws Exception{
        logger.info("Executando o método alteraEmail() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE PROFESSORES SET EMAIL = ? WHERE ID_PROFESSOR = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, professor.getEmail());
        pstmt.setLong(2,professor.getId());

        pstmt.executeUpdate();

        logger.info("O email do professor foi alterado com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }

    public boolean alteraTitulacao(Professor professor) throws Exception{
        logger.info("Executando o método alteraTitulacao() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE PROFESSORES SET TITULACAO = ? WHERE ID_PROFESSOR = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, professor.getTitulacao());
        pstmt.setLong(2,professor.getId());

        pstmt.executeUpdate();

        logger.info("A titulação do professor foi alterada com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;

    }
}

package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta;

import br.com.gilmarioarantes.jdbccrudv1.model.Professor;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaProfessor extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(ConsultaProfessor.class.getName());

    public Professor consultaPorId(Long id) throws Exception{

        logger.info("Executando o método consultaPorId() da classe: " + this.getClass().getSimpleName());

        Professor professor = new Professor();

        preparaPersistencia();

        String sql = "SELECT * FROM PROFESSORES WHERE ID_PROFESSOR = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        ResultSet rs = pstmt.executeQuery(  );

        while(rs.next()){
            professor.setId(rs.getLong("ID_PROFESSOR"));
            professor.setNome(rs.getString("NOME"));
            professor.setEmail(rs.getString("EMAIL"));
            professor.setTitulacao(rs.getString("TITULACAO"));
        }

        logger.info("A consulta de professor por id foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return professor;
    }

    public int obtemQuantidadeProfessores() throws Exception{

        logger.info("Executando o método obtemQuantidadeProfessores() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "SELECT COUNT(*) FROM PROFESSORES";

        int quantidadeProfessores = 0;

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            quantidadeProfessores = rs.getInt(1);
        }

        rs.close();
        stmt.close();
        connection.close();

        return quantidadeProfessores;

    }
}

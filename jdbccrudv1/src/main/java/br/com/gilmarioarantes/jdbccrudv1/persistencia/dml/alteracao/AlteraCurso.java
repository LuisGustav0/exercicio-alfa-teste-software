package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.model.Curso;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;

public class AlteraCurso extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(AlteraCurso.class.getName());

    public boolean alteraNome(Curso curso) throws Exception{
        logger.info("Executando o método alteraNome() da classe; " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "UPDATE CURSOS SET NOME = ? WHERE ID_CURSO = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, curso.getNome());
        pstmt.setLong(2, curso.getId());

        pstmt.executeUpdate();

        logger.info("O nome do curso [" + curso.getNome() + "] foi alterado com sucesso!");

        pstmt.close();
        stmt.close();
        connection.close();

        return true;
    }
}

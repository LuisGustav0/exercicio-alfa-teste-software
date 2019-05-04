package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta;

import br.com.gilmarioarantes.jdbccrudv1.model.Curso;
import br.com.gilmarioarantes.jdbccrudv1.model.Disciplina;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaDisciplina extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(ConsultaDisciplina.class.getName());

    public Disciplina consultaPorId(Long id) throws Exception{

        logger.info("Executando o método consultaPorId() da classe: " + this.getClass().getSimpleName());

        Disciplina disciplina = new Disciplina();

        preparaPersistencia();

        String sql = "SELECT * FROM DISCIPLINAS WHERE ID_DISCIPLINA = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        ResultSet rs = pstmt.executeQuery(  );
        Curso curso = new Curso();
        while(rs.next()){
            disciplina.setId(rs.getLong("ID_DISCIPLINA"));
            disciplina.setNome(rs.getString("NOME"));
            disciplina.setCargaHoraria(rs.getDouble("CARGA_HORARIA"));
            curso.setId(rs.getLong("CURSO"));
            disciplina.setCurso(curso);
        }

        logger.info("A consulta de disciplina por id foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return disciplina;
    }

    public int obtemQuantidadeDisciplinas() throws Exception{

        logger.info("Executando o método obtemQuantidadeDisciplinas() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "SELECT COUNT(*) FROM DISCIPLINAS";

        int quantidadeDisciplinas = 0;

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            quantidadeDisciplinas = rs.getInt(1);
        }

        rs.close();
        stmt.close();
        connection.close();

        return quantidadeDisciplinas;

    }
}

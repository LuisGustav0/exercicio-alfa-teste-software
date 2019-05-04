package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta;

import br.com.gilmarioarantes.jdbccrudv1.model.Curso;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsultaCurso extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(ConsultaCurso.class.getName());

    public Curso consultaPorId(long id) throws Exception{
        logger.info("Executando o método consultaPorId() da classe: " + this.getClass().getSimpleName());
        Curso curso = new Curso();
        preparaPersistencia();

        String sql = "SELECT * FROM CURSOS WHERE ID_CURSO = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,new Long(id));

        ResultSet rs = pstmt.executeQuery(  );
        while(rs.next()){
            curso.setId(rs.getLong("ID_CURSO"));
            curso.setNome(rs.getString("NOME"));
        }

        logger.info("A Consulta do curso pelo seu Id foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return curso;
    }

    public List<Curso> consultaPorNome(String nomeCurso) throws Exception{
        logger.info("Executando o método consultaPorNome() da classe: " + this.getClass().getSimpleName());
        List<Curso> cursos = new ArrayList<Curso>();
        preparaPersistencia();

        String sql = "SELECT * FROM CURSOS WHERE NOME LIKE ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,nomeCurso);

        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            cursos.add(new Curso(rs.getLong("ID_CURSO"),rs.getString("NOME")));
        }

        logger.info("A Consulta do curso pelo seu Nome foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();

        return cursos;
    }

    public List<Curso> listaTodos() throws Exception{
        logger.info("Executando o método listaTodos da classe: " + this.getClass().getSimpleName());
        List<Curso> cursos = new ArrayList<Curso>();
        preparaPersistencia();

        String sql = "SELECT * FROM CURSOS";

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            cursos.add(new Curso(rs.getLong("ID_CURSO"),rs.getString("NOME")));
        }

        logger.info("A Consulta de todos os cursos foi bem sucedida!");

        rs.close();
        stmt.close();
        connection.close();

        return cursos;
    }

    public int obtemQuantidadeCursos() throws Exception{

        logger.info("Executanto o método obtemQuantidadeCursos() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "SELECT COUNT(*) FROM CURSOS";

        ResultSet rs = stmt.executeQuery(sql);

        int quantidadeCursos = 0;

        while(rs.next()){
            quantidadeCursos = rs.getInt(1);
        }

        rs.close();
        stmt.close();
        connection.close();

        return quantidadeCursos;

    }
}

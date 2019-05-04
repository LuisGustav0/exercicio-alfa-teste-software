package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.gilmarioarantes.jdbccrudv1.util.FormataData;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ConsultaAluno extends PersistenciaJdbc {

    Logger logger = Logger.getLogger(ConsultaAluno.class.getName());

    public Aluno consultaPorId(Long id) throws Exception{
        logger.info("Executando o método consultaPorId() da classe: " + this.getClass().getSimpleName());
        preparaPersistencia();

        Aluno aluno = new Aluno();

        String sql = "SELECT * FROM ALUNOS WHERE ID_ALUNO = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            aluno.setId(rs.getLong("ID_ALUNO"));
            aluno.setMatricula(rs.getString("MATRICULA"));
            aluno.setNome(rs.getString("NOME"));
            aluno.setSexo(rs.getString("SEXO"));
            aluno.setDataNascimento(rs.getTimestamp("DATA_NASCIMENTO"));
        }

        logger.info("A consulta de aluno por id foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return aluno;
    }

    public Aluno consultaPorMatricula(String matricula) throws Exception{
        logger.info("Executando o método consultaPorMatricula() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        Aluno aluno = new Aluno();

        String sql = "SELECT * FROM ALUNOS WHERE MATRICULA = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,matricula);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            aluno.setId(rs.getLong("ID_ALUNO"));
            aluno.setMatricula(rs.getString("MATRICULA"));
            aluno.setNome(rs.getString("NOME"));
            aluno.setSexo(rs.getString("SEXO"));
            aluno.setDataNascimento(rs.getTimestamp("DATA_NASCIMENTO"));
        }

        logger.info("A consulta de aluno por id foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return aluno;
    }

    public List<Aluno> consultaPorNome(String nome) throws Exception{
        logger.info("Executando o método consultaPorNome() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * FROM ALUNOS WHERE NOME LIKE ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,nome);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            alunos.add(new Aluno(rs.getLong("ID_ALUNO"), rs.getString("MATRICULA"),
                    rs.getString("NOME"), rs.getString("SEXO"), rs.getTimestamp("DATA_NASCIMENTO")));
        }

        logger.info("A consulta de aluno por id foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return alunos;
    }

    public List<Aluno> consultaPorSexo(String sexo) throws Exception{
        logger.info("Executando o método consultaPorSexo() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * FROM ALUNOS WHERE SEXO LIKE ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,sexo);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            alunos.add(new Aluno(rs.getLong("ID_ALUNO"), rs.getString("MATRICULA"),
                    rs.getString("NOME"), rs.getString("SEXO"), rs.getTimestamp("DATA_NASCIMENTO")));
        }

        logger.info("A consulta de alunos por sexo foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return alunos;
    }

    public List<Aluno> consultaPorDataNascimento(Timestamp dataNascimento) throws Exception{
        logger.info("Executando o método consultaPorDataNascimento() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * FROM ALUNOS WHERE DATA_NASCIMENTO = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setTimestamp(1,dataNascimento);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            alunos.add(new Aluno(rs.getLong("ID_ALUNO"), rs.getString("MATRICULA"),
                    rs.getString("NOME"), rs.getString("SEXO"), rs.getTimestamp("DATA_NASCIMENTO")));
        }

        logger.info("A consulta de alunos pela data do nascimento foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return alunos;
    }

    public List<Aluno> consultaPorIntervaloDataNascimento(Timestamp dataNascimentoInicial, Timestamp dataNascimentoFinal) throws Exception{
        logger.info("Executando o método consultaPorIntervaloDataNascimento() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * FROM ALUNOS WHERE DATA_NASCIMENTO BETWEEN ? AND ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setTimestamp(1,dataNascimentoInicial);
        pstmt.setTimestamp(2,dataNascimentoFinal);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            alunos.add(new Aluno(rs.getLong("ID_ALUNO"), rs.getString("MATRICULA"),
                    rs.getString("NOME"), rs.getString("SEXO"), rs.getTimestamp("DATA_NASCIMENTO")));
        }

        logger.info("A consulta de alunos por intervalor de data do nascimento foi bem sucedida!");

        rs.close();
        pstmt.close();
        stmt.close();
        connection.close();
        return alunos;
    }

    public List<Aluno> listaTodos() throws Exception{
        logger.info("Executando o método listaTodos() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        List<Aluno> listaAlunos = new ArrayList<>();

        String sql = "SELECT * FROM ALUNOS";

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            listaAlunos.add(new Aluno(rs.getLong("ID_ALUNO"), rs.getString("MATRICULA"),
                    rs.getString("NOME"), rs.getString("SEXO"), rs.getTimestamp("DATA_NASCIMENTO")));
        }

        logger.info("A listagem de tdos os alunos foi bem sucedida!");

        rs.close();
        stmt.close();
        connection.close();
        return listaAlunos;
    }

    public int obtemQuantidadeAlunos() throws Exception{

        logger.info("Executanto o método obtemQuantidadeAlunos() da classe: " + this.getClass().getSimpleName());

        preparaPersistencia();

        String sql = "SELECT COUNT(*) FROM ALUNOS";

        int quantidadeAlunos = 0;

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            quantidadeAlunos = rs.getInt(1);
        }

        rs.close();
        stmt.close();
        connection.close();

        return quantidadeAlunos;

    }
}

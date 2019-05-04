package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraListaAlunos;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static java.time.Month.FEBRUARY;

public class PersisteAlunoTeste {

    Logger logger = Logger.getLogger(PersisteAlunoTeste.class.getName());

    @Test
    public void persisteAlunoTest() {

        logger.info("Executando o método persisteAlunoTest() da classe: " + this.getClass().getSimpleName());

        List<Aluno> alunos = GeraListaAlunos.geraLista();

        boolean result = false;

        try {
            for (Aluno aluno : alunos) {
                result = new PersisteAluno().persisteAluno(aluno);
            }
        } catch (Exception e) {
            result = false;
            logger.error("Erro ao persistir o Aluno!", e);
        }
        Assert.assertTrue(result);
    }

    @Test
    public void testIncluirAluno() {
        Timestamp dataNascimento = Timestamp.valueOf(LocalDateTime.of(1991, FEBRUARY, 7, 0, 0));

        Aluno aluno = new Aluno();
        aluno.setId(48L);
        aluno.setNome("Luis Gustavo");
        aluno.setDataNascimento(dataNascimento);
        aluno.setSexo("M");
        aluno.setMatricula("010251515454");

        boolean result = false;

        try {
            result = new PersisteAluno().persisteAluno(aluno);
        } catch (Exception e) {
            result = false;
            logger.error("Erro ao persistir o Aluno!", e);
        }
        Assert.assertTrue(result);
    }
}

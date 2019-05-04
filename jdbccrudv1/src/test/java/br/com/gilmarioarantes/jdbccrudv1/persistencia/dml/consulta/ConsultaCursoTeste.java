package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta;

import br.com.gilmarioarantes.jdbccrudv1.model.Curso;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao.PersisteCurso;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsultaCursoTeste {

    Logger logger = Logger.getLogger(ConsultaCursoTeste.class.getName());

    @Test
    public void consultaPorIdTeste(){

        logger.info("Executando o método consultaPorIdTeste() da classe" + this.getClass().getSimpleName());

        Curso curso = new Curso();

        try{
            curso = new ConsultaCurso().consultaPorId(new Long(new Random().nextLong()*5));
            Assert.assertTrue(curso.getId() > 0);
        } catch (Exception e){
            logger.error("Erro ao consultar o curso pelo Id!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultaPorNomeTest(){

        logger.info("Executando o método consultaPorNomeTeste() da classe" + this.getClass().getSimpleName());

        List<Curso> cursos = new ArrayList<Curso>();

        try{
            cursos = new ConsultaCurso().consultaPorNome("ENGENHARIA DE SOFTWARE");
            Assert.assertTrue(cursos.size() > 0);
        } catch (Exception e){
            logger.info("Erro ao consultar o curso pelo nome!", e);
        }
    }

    @Test
    public void listaTodosTeste(){

        logger.info("Executando o método listaTodosTeste() da classe" + this.getClass().getSimpleName());

        List<Curso> cursos = new ArrayList<Curso>();

        try{
            int quantidadeCursos = new ConsultaCurso().obtemQuantidadeCursos();
            cursos = new ConsultaCurso().listaTodos();
            Assert.assertTrue(cursos.size() == quantidadeCursos);
        } catch (Exception e){
            logger.error("Erro ao listar todos os cursos!", e);
            Assert.assertTrue(false);
        }
    }
}


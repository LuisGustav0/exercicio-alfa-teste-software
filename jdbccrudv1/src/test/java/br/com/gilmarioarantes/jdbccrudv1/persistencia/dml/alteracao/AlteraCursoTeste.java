package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.model.Curso;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaCurso;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AlteraCursoTeste {

    Logger logger = Logger.getLogger(AlteraCursoTeste.class.getName());

    int idCurso = 0;
    String nomeCurso = "";


    @Test
    public void alteraNomeCursoTeste(){
        logger.info("Executando o método alteraNomeCursoTeste() da classe: " + this.getClass().getSimpleName());
        try{
            int quantidadeCursos = new ConsultaCurso().obtemQuantidadeCursos();
            idCurso = new Random().nextInt(quantidadeCursos)+1;
            Curso curso = new ConsultaCurso().consultaPorId(new Long(idCurso));
            nomeCurso = curso.getNome();
            curso.setNome("CURSO COM O NOME ALTERADO");
            Assert.assertTrue(new AlteraCurso().alteraNome(curso));
        }catch (Exception e){
            logger.error("Erro ao alterar o nome do curso!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void reverteAlteraNomeCursoTeste(){
        logger.info("Executando o método reverteAlteracaoNomeCursoTeste() da classe: " + this.getClass().getSimpleName());
        try{
            Curso curso = new ConsultaCurso().consultaPorId(new Long(idCurso));
            curso.setNome(nomeCurso);
            Assert.assertTrue(new AlteraCurso().alteraNome(curso));
        }catch (Exception e){
            logger.error("Erro ao reverter a alteração do nome do curso!", e);
            Assert.assertTrue(false);
        }
    }
}

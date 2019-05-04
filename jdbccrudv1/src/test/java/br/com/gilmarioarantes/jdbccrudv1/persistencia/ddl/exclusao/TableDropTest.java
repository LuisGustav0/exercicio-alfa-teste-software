package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.exclusao;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TableDropTest {

    static Logger logger = Logger.getLogger(TableDropTest.class.getName());

    @Test
    public void _01deletaTabelaTurmasTest(){
        logger.info("Executando o método _01deletaTabelaTurmasTest() da classe: " + this.getClass().getSimpleName());
        try{
            Assert.assertTrue(new TableTurmasDrop().excluiTabela());
        }catch (Exception e){
            logger.info("Erro ao excluir a tabela Turmas!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void _02deletaTabelaDisciplinasTest(){
        logger.info("Executando o método _02deletaTabelaDisciplinasTest() da classe: " + this.getClass().getSimpleName());
        try{
            Assert.assertTrue(new TableDisciplinasDrop().excluiTabela());
        }catch (Exception e){
            logger.info("Erro ao excluir a tabela Disciplinas!",e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void _03deletaTabelaProfessoresTest(){
        logger.info("Executando o método _03deletaTabelaProfessoresTest() da classe: " + this.getClass().getSimpleName());
        try{
            Assert.assertTrue(new TableProfessoresDrop().excluiTabela());
        }catch (Exception e){
            logger.info("Erro ao excluir a tabela professores!",e);
            Assert.assertTrue(false);
        }

    }

    @Test
    public void _04deletaTabelaCursosTest(){
        logger.info("Executando o método _04deletaTabelaCursosTest() da classe: " + this.getClass().getSimpleName());
        try{
            Assert.assertTrue(new TableCursosDrop().excluiTabela());
        }catch (Exception e){
            logger.info("Erro ao excluir a tabela cursos!",e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void _05deletaTabelaAlunosTest(){
        logger.info("Executando o método _05deletaTabelaAlunosTest() da classe: " + this.getClass().getSimpleName());
        try{
            Assert.assertTrue(new TableAlunosDrop().excluiTabela());
        }catch (Exception e){
            logger.info("Erro ao excluir a tabela alunos!",e);
            Assert.assertTrue(false);
        }
    }
}

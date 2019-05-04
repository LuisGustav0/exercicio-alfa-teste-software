package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.criacao;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableCreateTest {

    static Logger logger = Logger.getLogger(TableCreateTest.class.getName());

    @Test
    public void _01criaTabelaAlunosTest(){
        logger.info("Executando o método _01criaTabelaAlunosTest() da classe: " + this.getClass().getSimpleName());
        try{
            Assert.assertTrue(new TableAlunosCreate().criaTabela());
        }catch (Exception e){
            logger.error("Erro ao criar a tabela alunos!",e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void _02criaTabelaCursosTest(){
        logger.info("Executando o método _02criaTabelaCursosTest() da classe: " + this.getClass().getSimpleName());
        try{
            Assert.assertTrue(new TableCursosCreate().criaTabela());
        }catch (Exception e){
            logger.error("Erro ao criar a tabela cursos!",e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void _03criaTabelaProfessoresTest(){
        logger.info("Executando o método _03criaTabelaProfessoresTest() da classe: " + this.getClass().getSimpleName());
        try{
            Assert.assertTrue(new TableProfessoresCreate().criaTabela());
        }catch (Exception e){
            logger.error("Erro ao criar a tabela professores!", e);
            Assert.assertTrue(false);
        }

    }

    @Test
    public void _04criaTabelaDisciplinasTest(){
        logger.info("Executando o método _04criaTabelaDisciplinasTest() da classe: " + this.getClass().getSimpleName());
        try{
            Assert.assertTrue(new TableDisciplinasCreate().criaTabela());
        }catch (Exception e){
            logger.error("Erro ao criar a tabela disciplinas!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void _05criaTabelaTurmasTest(){
        logger.info("Executando o método _05criaTabelaTurmasTest() da classe: " + this.getClass().getSimpleName());
        try{
            Assert.assertTrue(new TableTurmasCreate().criaTabela());
        }catch (Exception e){
            logger.error("Erro ao criar a tabela turmas!", e);
            Assert.assertTrue(false);
        }

    }

    @Test
    public void _06criaTabelaAlunosTurmasTest(){
        logger.info("Executando o método _06criaTabelaAlunosTurmasTest() da classe: " + this.getClass().getSimpleName());
        try{
            Assert.assertTrue(new TableAlunosTurmasCreate().criaTabela());
        }catch (Exception e){
            logger.error("Erro ao criar a tabela Alunos_Turmas!", e);
            Assert.assertTrue(false);
        }

    }
}

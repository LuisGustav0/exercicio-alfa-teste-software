package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.alteracao;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestaAlteracaoTabela {

    static Logger logger = Logger.getLogger(TestaAlteracaoTabela.class.getName());

    @Test
    public void adicaoFKTabelaDisciplinasTest(){

        logger.info("Executando o método adicaoFKTabelaDisciplinasTest() da classe: " + this.getClass().getSimpleName());

        try{
            Assert.assertTrue(new AdicionaFKTabelaDisciplinas().alteraTabela());
        }catch (Exception e){
            logger.error("Erro ao Adicionar FK na Tabela Disciplina", e);
            Assert.assertTrue(false);
        }

    }

    @Test
    public void adicaoFKTabelaTurmasTest(){

        logger.info("Executando o método adicaoFKTabelaTurmasTest() da classe: " + this.getClass().getSimpleName());

        try{
            Assert.assertTrue(new AdicionaFKTabelaTurmas().alteraTabela());
        }catch (Exception e){
            logger.error("Erro ao Adicionar FK na Tabela Turmas", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void adicaoFKTabelaAlunos_TurmasTest(){

        logger.info("Executando o método adicaoFKTabelaAlunos_TurmasTest() da classe: " + this.getClass().getSimpleName());

        try{
            Assert.assertTrue(new AdicionaFKTabelaAlunosTurmas().alteraTabela());
        }catch (Exception e){
            logger.error("Erro ao Adicionar FK na Tabela Alunos_Turmas", e);
            Assert.assertTrue(false);
        }
    }
}

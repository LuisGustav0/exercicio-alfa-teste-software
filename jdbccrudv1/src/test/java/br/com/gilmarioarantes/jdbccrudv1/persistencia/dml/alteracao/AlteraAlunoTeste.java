package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaAluno;
import br.com.gilmarioarantes.jdbccrudv1.util.FormataData;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlteraAlunoTeste {

    Logger logger = Logger.getLogger(AlteraAlunoTeste.class.getName());

    @Test(priority = 1)
    public void alteraMatriculaTest(){
        logger.info("Executando o método alteraMatriculaTest() da classe: " + this.getClass().getSimpleName());
        try{
            Aluno aluno = new ConsultaAluno().consultaPorId(new Long(35));
            aluno.setMatricula("2011100931");
            Assert.assertTrue(new AlteraAluno().alteraMatricula(aluno));
        }catch (Exception e){
            logger.error("Erro ao alterar a matrícula do aluno!", e);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2)
    public void reverteAlteracaoMatriculaTest(){
        logger.info("Executando o método reverteAlteracaoMatriculaTest() da classe: " + this.getClass().getSimpleName());
        try{
            Aluno aluno = new ConsultaAluno().consultaPorId(new Long(35));
            aluno.setMatricula("2018102689");
            Assert.assertTrue(new AlteraAluno().alteraMatricula(aluno));
        }catch (Exception e){
            logger.error("Erro ao reverter a alteração da matrícula do aluno!",e);
            Assert.assertTrue(false);
        }
    }


    @Test(priority = 3)
    public void alteraNomeTest(){
        logger.info("Executando o método alteraNomeTest() da classe: " + this.getClass().getSimpleName());
        try{
            Aluno aluno = new ConsultaAluno().consultaPorId(new Long(35));
            aluno.setNome("KEVIN DE SOUSA ANDRADE II");
            Assert.assertTrue(new AlteraAluno().alteraNome(aluno));
        }catch (Exception e){
            logger.error("Erro al alterar o nome do aluno!", e);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 4)
    public void reverteAlteracaoNomeTest(){
        logger.info("Executando o método reverteAlteracaoNomeTest() da classe: " + this.getClass().getSimpleName());
        try{
            Aluno aluno = new ConsultaAluno().consultaPorId(new Long(35));
            aluno.setNome("KEVIN DE SOUSA ANDRADE");
            Assert.assertTrue(new AlteraAluno().alteraNome(aluno));
        }catch (Exception e){
            logger.error("Erro ao reverter a alteração do nome do aluno!", e);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 5)
    public void alteraSexoTest(){
        logger.info("Executando o método alteraSexoTest() da classe: " + this.getClass().getSimpleName());
        try{
            Aluno aluno = new ConsultaAluno().consultaPorId(new Long(35));
            if(aluno.getSexo().equalsIgnoreCase("FEMININO")){
                aluno.setSexo("MASCULINO");
            }else{
                aluno.setSexo("FEMININO");
            }
            Assert.assertTrue(new AlteraAluno().alteraSexo(aluno));
        }catch (Exception e){
            logger.error("Erro ao alterar o sexo do aluno!", e);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 6)
    public void reverteAlteracaoSexoTest(){
        logger.info("Executando o método reverteAlteracaoSexoTest() da classe: " + this.getClass().getSimpleName());
        try{
            Aluno aluno = new ConsultaAluno().consultaPorId(new Long(35));
            if(aluno.getSexo().equalsIgnoreCase("FEMININO")){
                aluno.setSexo("MASCULINO");
            }else{
                aluno.setSexo("FEMININO");
            }
            Assert.assertTrue(new AlteraAluno().alteraSexo(aluno));
        }catch (Exception e){
            logger.error("Erro ao revereter a alteração do sexo do aluno!", e);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 7)
    public void alteraDataNascimentoTest(){
        logger.info("Executando o método alteraDataNascimentoTest() da classe: " + this.getClass().getSimpleName());
        try{
            Aluno aluno = new ConsultaAluno().consultaPorId(new Long(35));
            FormataData fd = new FormataData();
            String dataNascimento = "25/01/1978";
            aluno.setDataNascimento(fd.stringToTimeStamp(dataNascimento));
            Assert.assertTrue(new AlteraAluno().alteraDataNascimento(aluno));
        }catch (Exception e){
            logger.error("Erro ao alterar a data de nascimento do aluno!");
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 8)
    public void reverteAlteracaoDataNascimentoTest(){
        logger.info("Executando o método reverteAlteracaoDataNascimentoTest() da classe: " + this.getClass().getSimpleName());
        try{
            Aluno aluno = new ConsultaAluno().consultaPorId(new Long(35));
            FormataData fd = new FormataData();
            String dataNascimento = "23/11/2003";
            aluno.setDataNascimento(fd.stringToTimeStamp(dataNascimento));
            Assert.assertTrue(new AlteraAluno().alteraDataNascimento(aluno));
        }catch (Exception e){
            logger.error("Erro ao reverter a alteração da data de nascimento do aluno!", e);
            Assert.assertTrue(false);
        }
    }

}

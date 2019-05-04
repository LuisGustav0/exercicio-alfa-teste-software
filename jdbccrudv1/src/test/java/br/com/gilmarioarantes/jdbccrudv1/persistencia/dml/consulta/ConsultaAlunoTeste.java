package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.util.FormataData;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraData;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

public class ConsultaAlunoTeste {

    Logger logger = Logger.getLogger(ConsultaAluno.class.getName());

    @Test
    public void consultaPeloIdTest(){

        logger.info("Executado o Método consultaPeloIdTest() da classe: " + this.getClass().getSimpleName());

        try{
            Aluno aluno = new ConsultaAluno().consultaPorId(new Long(new Random().nextLong()*47));
            Assert.assertTrue(aluno.getId() != 0);
        }catch (Exception e){
            logger.error("Erro ao consultar o aluno pelo seu id!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultaPorMatriculaTest(){

        logger.info("Executado o Método consultaPorMatriculaTest() da classe: " + this.getClass().getSimpleName());

        try{
            String matriculas[] = {"201802671","201802672","201712899","201802675","201802676","201802679","201802681","201808731","201800214","201802683","201802684","201802687","201802688","201802690","201802692","201802696",
                    "201802697","201802854","201811631","201802705","201802707","201802709","201800236","201602532","201800219","201609827","201901191","201802678","201710946","201703673","201802723","201306671",
                    "201700268","201802827","201802689","201306365","201802694","201802695","201808738","201710986","201811303","201802702","201703695","201800216","201703699","201800813","201703701"};
            int indice = new Random().nextInt(matriculas.length)+1;
            Aluno aluno = new ConsultaAluno().consultaPorMatricula(matriculas[indice]);
            Assert.assertTrue(aluno.getMatricula().equals(matriculas[indice]));
        }catch (Exception e){
            logger.error("Erro ao consultar o aluno pelo sua matrícula!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultaPeloNomeTest(){

        logger.info("Executado o Método consultaPeloNome() da classe: " + this.getClass().getSimpleName());

        try{
            String nomes[] = {"FRANK", "ENZO", "CUNHA", "NASCIMENTO", "RIBEIRO", "OLIVEIRA"};
            int indice = new Random().nextInt(nomes.length)+1;
            List<Aluno> alunos = new ConsultaAluno().consultaPorNome(nomes[indice]);
            Assert.assertTrue(alunos.size() > 0);
        }catch (Exception e){
            logger.error("Erro ao consultar o aluno pelo seu nome!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultaPeloSexoTest(){

        logger.info("Executado o Método consultaPeloSexo() da classe: " + this.getClass().getSimpleName());

        try{
            String sexo[] = {"MASCULINO","FEMININO"};
            int indice = new Random().nextInt(sexo.length)+1;
            List<Aluno> alunos = new ConsultaAluno().consultaPorSexo(sexo[indice]);
            Assert.assertTrue(alunos.size() > 0);
        }catch (Exception e){
            logger.error("Erro ao consultar o aluno pelo seu nome!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultaPelaDataNascimentoTest(){

        logger.info("Executado o Método consultaPelaDataNascimentoTest() da classe: " + this.getClass().getSimpleName());

        try{
            Timestamp dataNascimento = new FormataData().stringToTimeStamp(GeraData.geraData());
            List<Aluno> alunos = new ConsultaAluno().consultaPorDataNascimento(dataNascimento);
            Assert.assertTrue(alunos.size() > 0);
        }catch (Exception e){
            logger.error("Erro ao consultar o aluno pelo seu nome!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultaPorIntervaloDataNascimentoTest(){

        logger.info("Executado o Método consultaPelaDataNascimentoTest() da classe: " + this.getClass().getSimpleName());

        try{
            Timestamp dataNascimentoInicial = new FormataData().stringToTimeStamp(GeraData.geraData());
            Timestamp dataNascimentoFinal = new FormataData().stringToTimeStamp(GeraData.geraData());
            List<Aluno> alunos = new ConsultaAluno().consultaPorIntervaloDataNascimento(dataNascimentoInicial,dataNascimentoFinal);
            Assert.assertTrue(alunos.size() > 0);
        }catch (Exception e){
            logger.error("Erro ao consultar o aluno pelo seu nome!", e);
            Assert.assertTrue(false);
        }
    }
}

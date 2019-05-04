package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.model.Curso;
import br.com.gilmarioarantes.jdbccrudv1.model.Disciplina;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaCurso;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaDisciplina;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlteraDisciplinaTeste {

    Logger logger = Logger.getLogger(AlteraDisciplinaTeste.class.getName());


    @Test
    public void alteraNomeDisciplinaTest(){

        logger.info("Executando o método alteraNomeDisciplinaTest() da classe: " + this.getClass().getSimpleName());

        try{
            Disciplina disciplina = new ConsultaDisciplina().consultaPorId(new Long(12));
            disciplina.setNome("Novo nome");
            Assert.assertTrue(new AlteraDisciplina().alteraNome(disciplina));
        }catch (Exception e){
            logger.error("Erro ao alterar o nome da disciplina!", e);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2)
    public void reverteAlteracaoNomeDisciplinaTest(){

        logger.info("Executando o método reverteAlteracaoNomeDisciplinaTest() da classe: " + this.getClass().getSimpleName());

        try{
            Disciplina disciplina = new ConsultaDisciplina().consultaPorId(new Long(12));
            disciplina.setNome("ENGENHARIA ECONÔMICA PARA SOFTWARE");
            Assert.assertTrue(new AlteraDisciplina().alteraNome(disciplina));
        }catch (Exception e){
            logger.error("Erro ao reverter a alteração do nome da disciplina!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void alteraCargaHorariaDisciplinaTest(){

        logger.info("Executando o método alteraCargaHorariaDisciplinaTest da classe: " + this.getClass().getSimpleName());

        try{
            Disciplina disciplina = new ConsultaDisciplina().consultaPorId(new Long(12));
            disciplina.setCargaHoraria(new Double(128.00));
            Assert.assertTrue(new AlteraDisciplina().alteraCargaHoraria(disciplina));
        }catch (Exception e){
            logger.error("Erro ao Alterar a carga horária da Disciplina.", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void reverteAlteracaoCargaHorariaDisciplinaTest(){

        logger.info("Executando o método reverteAlteracaoCargaHorariaDisciplinaTest da classe: " + this.getClass().getSimpleName());

        try{
            Disciplina disciplina = new ConsultaDisciplina().consultaPorId(new Long(12));
            disciplina.setCargaHoraria(new Double(64.00));
            Assert.assertTrue(new AlteraDisciplina().alteraCargaHoraria(disciplina));
        }catch (Exception e){
            logger.error("Erro ao reverter a alteração da carga horária da disciplina!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void alteraCursoDisciplinaTest(){

        logger.info("Executando o método alteraCursoDisciplinaTest() da classe: " + this.getClass().getSimpleName());

        try{
            Disciplina disciplina = new ConsultaDisciplina().consultaPorId(new Long(12));
            Curso curso = new ConsultaCurso().consultaPorId(new Long(3));
            disciplina.setCurso(curso);
            Assert.assertTrue(new AlteraDisciplina().alteraCurso(disciplina));
        }catch (Exception e){
            logger.error("Erro ao alterar o curso da disciplina!", e);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void reverteAlteracaoCursoDisciplinaTest(){

        logger.info("Executando o método reverteAlteracaoCursoDisciplinaTest() da classe: " + this.getClass().getSimpleName());

        try{
            Disciplina disciplina = new ConsultaDisciplina().consultaPorId(new Long(12));
            Curso curso = new ConsultaCurso().consultaPorId(new Long(4));
            disciplina.setCurso(curso);
            Assert.assertTrue(new AlteraDisciplina().alteraCurso(disciplina));
        }catch (Exception e){
            logger.error("Erro ao reverter a alteração do curso da disciplina!", e);
            Assert.assertTrue(false);
        }
    }
}

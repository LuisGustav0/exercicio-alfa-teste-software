package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.model.Disciplina;
import br.com.gilmarioarantes.jdbccrudv1.model.Professor;
import br.com.gilmarioarantes.jdbccrudv1.model.Turma;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaAluno;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaDisciplina;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaProfessor;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class PersisteTurmaTeste {

    Logger logger = Logger.getLogger(PersisteTurmaTeste.class.getName());

    @Test
    public void persisteTurmaTest(){

        logger.info("Executando o método persisteTurmaTest() da classe: " + this.getClass().getSimpleName());

        boolean result = false;

        try{

            int quantidadeAlunos = new ConsultaAluno().obtemQuantidadeAlunos();
            int quantidadeProfessores = new ConsultaProfessor().obtemQuantidadeProfessores();
            int quantidadeDisciplinas = new ConsultaDisciplina().obtemQuantidadeDisciplinas();

            for(int i = 0; i < quantidadeAlunos; i++){
                Turma turma = new Turma();
                turma.setId(new Long(i));
                turma.setSemestre("20191");

                int idProfessor = new Random().nextInt(quantidadeProfessores)+1;
                Professor professor = new ConsultaProfessor().consultaPorId(new Long(idProfessor));
                if(professor.getId() != null){
                    turma.setProfessor(professor);
                }else{
                    logger.error("Erro ao consultar o professor da turma");
                }

                int idDisciplina = new Random().nextInt(quantidadeDisciplinas)+1;
                Disciplina disciplina = new ConsultaDisciplina().consultaPorId(new Long(idDisciplina));
                if(disciplina.getId() != null){
                    turma.setDisciplina(disciplina);
                }else{
                    logger.error("Erro ao consultar a disciplina da turma");
                }

                result = new PersisteTurma().persisteTurma(turma);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
}

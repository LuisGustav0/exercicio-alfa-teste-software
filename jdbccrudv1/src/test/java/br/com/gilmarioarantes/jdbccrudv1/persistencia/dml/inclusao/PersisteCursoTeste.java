package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Curso;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersisteCursoTeste {

    Logger logger = Logger.getLogger(PersisteCursoTeste.class.getName());

    //Teste da persistência de mais de um curso.
    @Test
    public void persisteCursosTest(){

        logger.info("Executando o método persisteCursosTest() da classe: " + this.getClass().getSimpleName());


        Long ids[] = {new Long(1), new Long(2), new Long(3), new Long(4)};

        String cursos[] = {"ENGENHARIA DE SOFTWARE","CIÊNCIA DA COMPUTAÇÃO","SISTEMAS DE INFORMAÇÃO","ENGENHARIA DA COMPUTAÇÃO"};

        try{
            for (int i = 0; i < cursos.length; i++){
                Curso curso = new Curso();
                curso.setId(ids[i]);
                curso.setNome(cursos[i]);
                Assert.assertTrue(new PersisteCurso().persisteCurso(curso));
            }
        }catch (Exception e){
            logger.error("Erro ao persistir o curso!", e);
            Assert.assertTrue(false);
        }
    }
}
